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

import com.assemblade.client.CallFailedException;
import com.assemblade.client.ChangePasswordException;
import com.assemblade.client.ClientException;
import com.assemblade.client.Login;
import com.assemblade.client.Users;
import com.assemblade.client.model.Authentication;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class LoginScreen extends VerticalLayout implements LoginForm.LoginListener {
    private CatApplication app;

    public LoginScreen () {
        app = CatApplication.getInstance();
        setSizeFull();
        Panel loginPanel = new Panel("Login");
        loginPanel.setWidth("400px");
        LoginForm loginForm = new LoginForm();
        loginForm.setUsernameCaption("Username: ");
        loginForm.setPasswordCaption("Password: ");
        loginForm.addListener(this);
        loginForm.setHeight("150px");
        loginPanel.addComponent(loginForm);
        addComponent(loginPanel);
        setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setHeight("50px");
        addComponent(footer);
    }

    @Override
    public void onLogin(LoginForm.LoginEvent event) {
        String username = event.getLoginParameter("username");
        String password = event.getLoginParameter("password");

        Login login = new Login("http://localhost:20080/cat-rest-api");

        Authentication authentication = null;

        try {
            authentication = login.login(username, password);
        } catch (ChangePasswordException e) {
            e.printStackTrace();
        } catch (CallFailedException e) {
            e.printStackTrace();
        }

        if (authentication == null) {
            showInvalidPassword();
            return;
        }

        Users users = new Users(authentication);
        try {
            app.setUser(users.getAuthenticatedUser());
        } catch (ClientException e) {
        }
        if (app.getUser() == null) {
            throw new NullPointerException("User must not be null");
        }
        app.setAuthentication(authentication);
        app.getViewManager().switchScreen(CatView.class.getName(), new CatView(app.getUser()));
    }

    void showInvalidPassword() {
        getWindow().showNotification("Invalid credentials", "<br/>" + "The username or password were not recognised by the CAT server", Window.Notification.TYPE_ERROR_MESSAGE);
    }
}