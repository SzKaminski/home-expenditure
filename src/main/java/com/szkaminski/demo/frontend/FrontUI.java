package com.szkaminski.demo.frontend;

import com.szkaminski.demo.backend.model.Bill;
import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.BillService;
import com.szkaminski.demo.backend.services.ExpenditureService;
import com.szkaminski.demo.backend.services.UserService;
import com.szkaminski.demo.frontend.buttons.BillButton;
import com.szkaminski.demo.frontend.buttons.NewBillButton;
import com.szkaminski.demo.frontend.layouts.NewBillLayout;
import com.szkaminski.demo.frontend.layouts.NewExpenditureLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class FrontUI extends Div {

    @Getter
    private static NewBillLayout newBillLayout;
    @Getter
    private static NewExpenditureLayout newExpenditureLayout;

    private static UserService userService;

    public FrontUI(@Autowired UserService userService,
                   @Autowired BillService billService,
                   @Autowired ExpenditureService expenditureService) {

        FrontUI.userService = userService;
        User loggedUser = new User();
        if (userService.getUser().isPresent()) {
            loggedUser = userService.getUser().get();
        }

        addLabel();

        NewBillButton buttonOpenBill = new NewBillButton();
        newBillLayout = new NewBillLayout(userService);
        add(newBillLayout);
        add(buttonOpenBill);

        newExpenditureLayout = new NewExpenditureLayout();
        add(newExpenditureLayout);

        Label label = new Label("Your bills");
        add(label);

        for (Bill b : loggedUser.getBills()) {
            add(new BillButton(b.getName(), billService, expenditureService, loggedUser));
        }
    }

    private void addLabel() {
        if (userService.getUser().isPresent()) {
            Label label = new Label("HELLO " + userService.getUser().get().getName());
            add(label);
        }
    }

}
