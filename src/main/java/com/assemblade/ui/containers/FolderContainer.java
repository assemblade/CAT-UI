/*
 * Copyright 2013 Mike Adamson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assemblade.ui.containers;

import com.assemblade.client.ClientException;
import com.assemblade.client.Folders;
import com.assemblade.client.model.Folder;
import com.assemblade.ui.CatApplication;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.MethodProperty;

import java.util.ArrayList;
import java.util.Collection;

public class FolderContainer implements Container.Hierarchical {
    private CatApplication app;
    private Folders folders;

    public FolderContainer() {
        app = CatApplication.getInstance();
        folders = new Folders(app.getAuthentication());
    }

    @Override
    public Collection<?> getChildren(Object itemId) {
        try {
            return folders.getChildFolders((Folder)itemId);
        } catch (ClientException e) {
        }
        return new ArrayList<Folder>();
    }

    @Override
    public Object getParent(Object itemId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<?> rootItemIds() {
        try {
            return folders.getRootFolders();
        } catch (ClientException e) {
        }
        return new ArrayList<Folder>();
    }

    @Override
    public boolean setParent(Object itemId, Object newParentId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean areChildrenAllowed(Object itemId) {
        return true;
    }

    @Override
    public boolean setChildrenAllowed(Object itemId, boolean areChildrenAllowed) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRoot(Object itemId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasChildren(Object itemId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Item getItem(Object itemId) {
        return new BeanItem(itemId);
    }

    @Override
    public Collection<?> getContainerPropertyIds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<?> getItemIds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Property getContainerProperty(Object itemId, Object propertyId) {
        return new MethodProperty<Folder>((Folder)itemId, (String)propertyId);
    }

    @Override
    public Class<?> getType(Object propertyId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsId(Object itemId) {
        Folder folder = (Folder)itemId;
        try {
            return folders.getFolder(folder.getUrl()) != null;
        } catch (ClientException e) {
        }
        return false;
    }

    @Override
    public Item addItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object addItem() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addContainerProperty(Object propertyId, Class<?> type, Object defaultValue) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeContainerProperty(Object propertyId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAllItems() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
