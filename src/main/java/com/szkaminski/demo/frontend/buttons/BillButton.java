package com.szkaminski.demo.frontend.buttons;

import com.szkaminski.demo.backend.model.Bill;
import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.BillService;
import com.szkaminski.demo.backend.services.ExpenditureService;
import com.szkaminski.demo.frontend.FrontUI;
import com.szkaminski.demo.frontend.layouts.ExpanditureCreator;
import com.szkaminski.demo.frontend.layouts.NewExpenditureLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;

public class BillButton extends Button {

    public BillButton(String text, BillService billService, ExpenditureService expenditureService,
                      User user) {
        super(text);

        this.addClickListener(e -> {
            Bill bill = billService.getByName(text);
            NewExpenditureLayout layout = FrontUI.getNewExpenditureLayout();
            layout.removeAll();
            layout.setVisible(true);
            layout.add(
                    new Label(bill.getName() + " :: " + bill.getSum() + " :: " + bill.getYearOfCreation()),
                    new ExpanditureCreator(expenditureService, user)
            );
        });
    }
}
