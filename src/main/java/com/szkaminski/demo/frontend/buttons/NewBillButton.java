package com.szkaminski.demo.frontend.buttons;

import com.szkaminski.demo.frontend.FrontUI;
import com.vaadin.flow.component.button.Button;

public class NewBillButton extends Button {

    public NewBillButton() {
        super("open new bill");

        this.addClickListener(e -> {
            this.setVisible(false);
            FrontUI.getNewBillLayout().setVisible(true);
        });
    }

}
