package com.assemblade.ui.components;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.themes.ChameleonTheme;

public class MainSplitter extends HorizontalSplitPanel {
    public MainSplitter() {
        setSizeFull();
        setSplitPosition(20, Sizeable.UNITS_PERCENTAGE);
        addStyleName(ChameleonTheme.SPLITPANEL_SMALL);
        addComponent(new LeftPane());
        addComponent(new RightPane());
    }
}
