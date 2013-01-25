package com.assemblade.ui.components;

import com.assemblade.ui.CatApplication;
import com.assemblade.ui.views.LoginScreen;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ChameleonTheme;

public class TitleBar extends GridLayout {
    public TitleBar() {
        super(6, 1);
        setStyleName(ChameleonTheme.PANEL_BUBBLE);
        setWidth("100%");
        setHeight("60px");
        setSpacing(true);
        Label companyLabel = new Label("Assemblade CAT");
        companyLabel.setWidth("200px");
        companyLabel.addStyleName("h1 color");

        addComponent(companyLabel, 0, 0);
        setComponentAlignment(companyLabel, Alignment.MIDDLE_CENTER);

        final CatApplication app = CatApplication.getInstance();

        Button logout = new Button("Logout: " + app.getUser().getFullName());
        logout.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                app.logout();
                app.getViewManager().switchScreen(LoginScreen.class.getName(), new LoginScreen());
            }
        });

        addComponent(logout, 5, 0);
        setComponentAlignment(logout, Alignment.MIDDLE_CENTER);
    }
}
