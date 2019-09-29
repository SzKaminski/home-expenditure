package com.szkaminski.demo.frontend.layouts;

import com.szkaminski.demo.backend.services.UserService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class NewBillLayout extends VerticalLayout {

    private AddOwnerTexfieldLayout owners;

    public NewBillLayout(UserService userService) {
        setVisible(false);
        owners = new AddOwnerTexfieldLayout(userService);
        add(owners);
    }
}
