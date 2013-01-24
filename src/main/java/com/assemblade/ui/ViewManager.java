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

import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;

import java.util.HashMap;
import java.util.Stack;

public class ViewManager {
    HashMap<String, Layout> views = new HashMap<String, Layout>();
    Stack<Layout> screenStack = new Stack<Layout>();
    Panel window;

    public ViewManager (Panel window) {
        this.window = window;
    }

    public void switchScreen(String viewName, Layout newView) {
        Layout view;
        if (newView != null) {
            view = newView;
            views.put(viewName, newView);
        } else
        view = views.get(viewName);
        window.setContent(view);
    }

    public void pushScreen(String viewName, Layout newView) {
        screenStack.push((Layout) window.getContent());
        switchScreen(viewName, newView);
    }

    public void popScreen() {
        window.setContent(screenStack.pop());
    }

    public Panel getWindow() {
        return window;
    }
}
