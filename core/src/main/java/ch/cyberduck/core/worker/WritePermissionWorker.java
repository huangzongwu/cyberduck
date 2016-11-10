package ch.cyberduck.core.worker;

/*
 * Copyright (c) 2013 David Kocher. All rights reserved.
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
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.ch
 */

import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Permission;
import ch.cyberduck.core.PermissionOverwrite;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.ConnectionCanceledException;
import ch.cyberduck.core.features.UnixPermission;

import java.text.MessageFormat;
import java.util.List;

public class WritePermissionWorker extends Worker<Boolean> {

    /**
     * Selected files.
     */
    private final List<Path> files;

    /**
     * Permissions to apply to files.
     */
    private final PermissionOverwrite permissions;

    /**
     * Descend into directories
     */
    private final RecursiveCallback<PermissionOverwrite> callback;

    private final ProgressListener listener;

    public WritePermissionWorker(final List<Path> files,
                                 final PermissionOverwrite permissions,
                                 final boolean recursive,
                                 final ProgressListener listener) {
        this(files, permissions, new BooleanRecursiveCallback<>(recursive), listener);
    }

    public WritePermissionWorker(final List<Path> files,
                                 final PermissionOverwrite permissions,
                                 final RecursiveCallback<PermissionOverwrite> callback,
                                 final ProgressListener listener) {
        this.files = files;
        this.permissions = permissions;
        this.callback = callback;
        this.listener = listener;
    }

    @Override
    public Boolean run(final Session<?> session) throws BackgroundException {
        final UnixPermission feature = session.getFeature(UnixPermission.class);
        for(Path file : files) {
            if(this.isCanceled()) {
                throw new ConnectionCanceledException();
            }
            this.write(session, feature, file);
        }
        return true;
    }

    protected void write(final Session<?> session, final UnixPermission feature, final Path file) throws BackgroundException {
        final Permission merged = permissions.resolve(file.attributes().getPermission());
        listener.message(MessageFormat.format(LocaleFactory.localizedString("Changing permission of {0} to {1}", "Status"),
                file.getName(), merged));
        feature.setUnixPermission(file, merged);
        if(file.isDirectory()) {
            if(callback.recurse(file, permissions)) {
                for(Path child : session.list(file, new ActionListProgressListener(this, listener))) {
                    this.write(session, feature, child);
                }
            }
        }
    }

    @Override
    public String getActivity() {
        return MessageFormat.format(LocaleFactory.localizedString("Changing permission of {0} to {1}", "Status"),
                this.toString(files), permissions);
    }

    @Override
    public Boolean initialize() {
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final WritePermissionWorker that = (WritePermissionWorker) o;
        if(files != null ? !files.equals(that.files) : that.files != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return files != null ? files.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WritePermissionWorker{");
        sb.append("files=").append(files);
        sb.append('}');
        return sb.toString();
    }

}
