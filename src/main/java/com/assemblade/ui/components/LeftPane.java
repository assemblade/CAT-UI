package com.assemblade.ui.components;

import com.assemblade.ui.CatApplication;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ChameleonTheme;

public class LeftPane extends Panel implements ItemClickEvent.ItemClickListener {
    private FolderTree tree;


    public LeftPane() {
        addStyleName(ChameleonTheme.PANEL_BUBBLE);
        setSizeFull();
        getContent().setSizeUndefined();
        tree = new FolderTree();
        addComponent(tree);
        tree.addListener(this);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        CatApplication.getInstance().getWindow().showNotification("Received: " + event.toString());
    }
}
