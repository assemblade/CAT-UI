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

package com.assemblade.ui.views;

import com.assemblade.client.model.User;
import com.assemblade.ui.CatApplication;
import com.assemblade.ui.components.LeftPane;
import com.assemblade.ui.components.MainSplitter;
import com.assemblade.ui.components.RightPane;
import com.assemblade.ui.components.TitleBar;
import com.assemblade.ui.containers.FolderContainer;
import com.assemblade.ui.views.LoginScreen;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

public class MainScreen extends VerticalLayout {
    public MainScreen() {
        setSizeFull();
        setMargin(false);

        addComponent(new TitleBar());

        MainSplitter mainSplitter = new MainSplitter();

        addComponent(mainSplitter);

        setExpandRatio(mainSplitter, 1.0f);
    }
}
