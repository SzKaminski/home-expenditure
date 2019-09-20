package com.szkaminski.demo.frontend;

import com.szkaminski.demo.backend.services.UserService;
import com.szkaminski.demo.frontend.buttons.NewBillButton;
import com.szkaminski.demo.frontend.layouts.NewBillLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class FrontUI extends Div  {

    @Getter
    private static NewBillLayout newBillLayout;

    public FrontUI(@Autowired UserService userService) {
        Label label = new Label("HELLO");
        add(label);

        NewBillButton buttonOpenBill = new NewBillButton("Open new bill");
        newBillLayout = new NewBillLayout(userService);
        newBillLayout.setVisible(false);

        add(newBillLayout);
        add(buttonOpenBill);
    }


}
