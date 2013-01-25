package com.assemblade.ui.components;

import com.assemblade.ui.containers.FolderContainer;
import com.vaadin.ui.Tree;

public class FolderTree extends Tree {
    public FolderTree() {
        setContainerDataSource(new FolderContainer());
        setItemCaptionPropertyId("name");
    }
}
