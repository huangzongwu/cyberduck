package ch.cyberduck.core;

/*
 *  Copyright (c) 2004 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import com.apple.cocoa.foundation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
* @version $Id$
 */
public class DownloadQueue extends Queue {
	
	public NSMutableDictionary getAsDictionary() {
        NSMutableDictionary dict = super.getAsDictionary();
        dict.setObjectForKey(Queue.KIND_DOWNLOAD+"", "Kind");
        return dict;
    }
	
	public List getChilds(Path p) {
		return this.getChilds(new ArrayList(), p);
	}
	
	private List getChilds(List list, Path p) {
        list.add(p);
        if (p.attributes.isDirectory() && !p.attributes.isSymbolicLink()) {
            p.status.setSize(0); //@todo
            for (Iterator i = p.list(false, true).iterator(); i.hasNext();) {
                Path child = (Path)i.next();
                child.setLocal(new Local(p.getLocal(), child.getName()));
				this.getChilds(list, child);
            }
        }
		return list;
	}
	
	protected void process(Path p) {
		p.download();
	}
}