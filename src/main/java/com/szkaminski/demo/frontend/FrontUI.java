package com.szkaminski.demo.frontend;

import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.UserService;
import com.szkaminski.demo.frontend.buttons.NewBillButton;
import com.szkaminski.demo.frontend.layouts.NewBillLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Route("")
public class FrontUI extends Div {

    @Getter
    private static NewBillLayout newBillLayout;

    static UserService userService;
    public FrontUI(@Autowired UserService userService) {
        FrontUI.userService = userService;

        if (getUser().isPresent()) {
            Label label = new Label("HELLO " + getUser().get().getName());
            add(label);
        }
        NewBillButton buttonOpenBill = new NewBillButton();
        newBillLayout = new NewBillLayout(userService);
        newBillLayout.setVisible(false);

        add(newBillLayout);
        add(buttonOpenBill);
    }

    public static Optional<User> getUser() {
        User user = userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        return Optional.ofNullable(user);
    }
}
