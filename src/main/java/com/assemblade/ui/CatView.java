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

package com.assemblade.ui;

import com.assemblade.client.model.User;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

public class CatView extends VerticalLayout {
    private User user;
    private CatApplication app;

    public CatView(User user) {
        this.user = user;
        this.app = CatApplication.getInstance();
        setSizeFull();
        setMargin(false);

        GridLayout titleBar = new GridLayout(6, 1);
        titleBar.setStyleName(ChameleonTheme.PANEL_BUBBLE);
        titleBar.setWidth("100%");
        titleBar.setHeight("60px");
        titleBar.setSpacing(true);
        Label companyLabel = new Label("Assemblade CAT");
        companyLabel.setWidth("200px");
        companyLabel.addStyleName("h1 color");

        titleBar.addComponent(companyLabel, 0, 0);
        titleBar.setComponentAlignment(companyLabel, Alignment.MIDDLE_CENTER);

        Button logout = new Button("Logout: " + user.getFullName());
        logout.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                app.logout();
                app.getViewManager().switchScreen(LoginScreen.class.getName(), new LoginScreen());
            }
        });

        titleBar.addComponent(logout, 5, 0);
        titleBar.setComponentAlignment(logout, Alignment.MIDDLE_CENTER);

        addComponent(titleBar);

        HorizontalSplitPanel mainLayout = new HorizontalSplitPanel();
        mainLayout.setSizeFull();
        mainLayout.setSplitPosition(20, Sizeable.UNITS_PERCENTAGE);
        mainLayout.addStyleName(ChameleonTheme.SPLITPANEL_SMALL);

        addComponent(mainLayout);

        setExpandRatio(mainLayout, 1.0f);

        Panel treePanel = new Panel();
        treePanel.addStyleName(ChameleonTheme.PANEL_BUBBLE);
        treePanel.setSizeFull();
        treePanel.getContent().setSizeUndefined();

        mainLayout.addComponent(treePanel);

        Tree tree = new Tree();
        tree.setContainerDataSource(new FolderTreeContainer());
        tree.setItemCaptionPropertyId("name");
        treePanel.addComponent(tree);

        // vertically divide the right area
        VerticalLayout rightLayout = new VerticalLayout();
        rightLayout.setSizeFull();

        mainLayout.addComponent(rightLayout);

        // table on top
        Table tbl = new Table();
        tbl.setSizeFull();
        tbl.setContainerDataSource(ExampleUtil.getISO3166Container());
        tbl.setSortDisabled(true);
        rightLayout.addComponent(tbl);
    }
}
