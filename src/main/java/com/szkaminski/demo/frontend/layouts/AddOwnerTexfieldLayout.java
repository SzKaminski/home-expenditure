package com.szkaminski.demo.frontend.layouts;

import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.UserService;
import com.szkaminski.demo.frontend.FrontUI;
import com.szkaminski.demo.frontend.textfields.OwnerTextfield;
import com.szkaminski.demo.frontend.validators.FieldValidator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

class AddOwnerTexfieldLayout extends VerticalLayout {

    @Getter
    private final Button SAVE_BUTTON, NEW_OWNERTEXFIELD_BUTTON;

    @Getter
    OwnerTextfield addOwnerTextfield;

    @Getter
    Set<String> ownerTextfieldsListValues;

    Binder<User> userBinder;

    AddOwnerTexfieldLayout(@Autowired UserService userService) {
        ownerTextfieldsListValues = new HashSet<>();
        addOwnerTextfield = new OwnerTextfield();

        NEW_OWNERTEXFIELD_BUTTON = new Button("add new ");
        SAVE_BUTTON = new Button("open new bill");
        add(addOwnerTextfield);
        Div buttons = new Div(NEW_OWNERTEXFIELD_BUTTON, SAVE_BUTTON);
        add(buttons);

        userBinder = new Binder<>();
        setBinder(addOwnerTextfield);

        NEW_OWNERTEXFIELD_BUTTON.addClickListener(e -> {
            if (userBinder.validate().isOk()) {
                remove(buttons);
                addToNewOwnerList(addOwnerTextfield);
                addOwnerTextfield.setEnabled(false);
                addOwnerTextfield = new OwnerTextfield();
                setBinder(addOwnerTextfield);
                add(addOwnerTextfield);
                add(buttons);
            }
        });

        SAVE_BUTTON.addClickListener(e -> {
            if (userBinder.validate().isOk()) {
                addToNewOwnerList(addOwnerTextfield);
                for (String name : ownerTextfieldsListValues) {
                    if (userService.findByName(name) != null || name.equals("szymon")) {
                        Notification.show("find " + name);
                        FrontUI.getNewBillLayout().setVisible(false);
                    } else {
                        Notification.show("Users " + name + " not found");
                    }
                }
            }
        });

    }

    private void setBinder(OwnerTextfield ownerTextfield) {
        userBinder.forField(ownerTextfield)
                .withValidator(new FieldValidator("type good name"))
                .bind(User::getName,User::setName);
    }

    private void addToNewOwnerList(TextField fromField) {
        if (!fromField.getValue().equals("") || fromField.getValue() != null) {
                ownerTextfieldsListValues.add(fromField.getValue());
        } else {
            Notification.show("uzupełnij pola");
        }
    }
}
