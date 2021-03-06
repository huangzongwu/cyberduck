package ch.cyberduck.core;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CertificateStoreFactory extends Factory<CertificateStore> {
    private static final Logger log = Logger.getLogger(CertificateStoreFactory.class);

    private static final CertificateStoreFactory factory = new CertificateStoreFactory();

    protected CertificateStoreFactory() {
        super("factory.certificatestore.class");
    }

    public CertificateStore create(final Controller c) {
        try {
            final Constructor<CertificateStore> constructor = ConstructorUtils.getMatchingAccessibleConstructor(clazz, c.getClass());
            if(null == constructor) {
                log.warn(String.format("No matching constructor for parameter %s", c.getClass()));
                // Call default constructor for disabled implementations
                return clazz.newInstance();
            }
            return constructor.newInstance(c);
        }
        catch(InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new FactoryException(e.getMessage(), e);
        }
    }

    public static CertificateStore get() {
        return factory.create();
    }

    public static CertificateStore get(final Controller c) {
        return factory.create(c);
    }
}
