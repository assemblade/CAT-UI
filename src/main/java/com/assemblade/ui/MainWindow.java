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

import com.vaadin.ui.ExpandLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OrderedLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;

import java.util.Iterator;

public class MainWindow extends Window {
    public MainWindow() {
        setCaption("CAT");
        setImmediate(true);

        VerticalLayout main = new VerticalLayout();
        main.setSizeFull();
        main.setMargin(false);

        setContent(main);

        HorizontalLayout titleBar = new HorizontalLayout();
        titleBar.setStyleName(ChameleonTheme.PANEL_BUBBLE);
        titleBar.setWidth("100%");
        titleBar.setSpacing(true);
        Label companyLabel = new Label("Assemblade CAT");
        companyLabel.setStyleName(ChameleonTheme.LABEL_COLOR);
        titleBar.addComponent(companyLabel);

        addComponent(titleBar);

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();

        addComponent(mainLayout);

        main.setExpandRatio(mainLayout, 1.0f);

        // Tree to the left
        Panel treePanel = new Panel(); // for scrollbars
        treePanel.setStyleName(ChameleonTheme.PANEL_BORDERLESS);
        treePanel.setHeight("100%");
        treePanel.setWidth(null);
        treePanel.getContent().setSizeUndefined();

        mainLayout.addComponent(treePanel);

        Tree tree = new Tree();
        tree.setContainerDataSource(new FolderContainer());
        tree.setItemCaptionPropertyId("name");
//        for (Iterator<?> it = tree.rootItemIds().iterator(); it.hasNext();) {
//            tree.expandItemsRecursively(it.next());
//        }
        treePanel.addComponent(tree);

        // vertically divide the right area
        VerticalLayout left = new VerticalLayout();
        left.setSizeFull();

        mainLayout.addComponent(left);
        mainLayout.setExpandRatio(left, 1.0f); // use all available space

        // table on top
        Table tbl = new Table();
        tbl.setSizeFull();
//        tbl.setWidth("100%");
        tbl.setContainerDataSource(ExampleUtil.getISO3166Container());
        tbl.setSortDisabled(true);
//        tbl.setPageLength(50);
        left.addComponent(tbl);
    }
}
