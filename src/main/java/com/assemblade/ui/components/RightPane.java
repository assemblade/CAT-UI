package com.assemblade.ui.components;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class RightPane extends VerticalLayout {
    private TabSheet tabSheet;

    public RightPane() {
        setSizeFull();
        tabSheet = new TabSheet();
        addComponent(tabSheet);
    }
}
