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

import com.assemblade.client.model.Authentication;
import com.assemblade.client.model.User;
import com.assemblade.ui.utils.ViewManager;
import com.assemblade.ui.views.LoginScreen;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Window;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatApplication extends Application implements HttpServletRequestListener {
    private static ThreadLocal<CatApplication> instance = new ThreadLocal<CatApplication>();

    private ViewManager viewManager;

    private Window mainWindow;

    private Authentication authentication;

    public CatApplication() {
        instance.set(this);
    }

    @Override
    public void init() {
        setTheme("cat-chameleon");

        mainWindow = new Window("CAT");

        setMainWindow(mainWindow);

        viewManager = new ViewManager(mainWindow);
        viewManager.switchScreen(LoginScreen.class.getName(), new LoginScreen());
    }

    @Override
    public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        instance.set(this);
    }

    @Override
    public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        instance.remove();
    }

    public static CatApplication getInstance() {
        return instance.get();
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public User getUser() {
        return (User)super.getUser();
    }

    public Window getWindow() {
        return mainWindow;
    }

    public void logout() {
        setAuthentication(null);
        setUser(null);
    }
}
