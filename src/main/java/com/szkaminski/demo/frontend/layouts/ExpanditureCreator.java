package com.szkaminski.demo.frontend.layouts;

import com.szkaminski.demo.backend.model.Expenditure;
import com.szkaminski.demo.backend.model.Type;
import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.services.ExpenditureService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;

import java.math.BigDecimal;

public class ExpanditureCreator extends VerticalLayout {

    private Binder<Expenditure> binder;

    public ExpanditureCreator(ExpenditureService expenditureService,
                              User user) {

        binder = new Binder<>();
        NumberField amountNumberfield = new NumberField("set amount");
        //TODO:binder
/*        binder.forField(amountNumberfield)
                .withValidator(field -> field != null,"Field cannot be empty")
                .bind(Expenditure::getAmount, Expenditure::setAmount);*/
        DatePicker setDatePicker = new DatePicker("set date");
        ComboBox<Type> comboBox = new ComboBox<>();
        comboBox.setItems(Type.values());
        comboBox.setLabel("set type");

        Button addExpendButton = new Button("add");
        addExpendButton.addClickListener(event -> {
            Expenditure exp = new Expenditure();
            exp.setAmount(BigDecimal.valueOf(amountNumberfield.getValue()));
            exp.setDate(setDatePicker.getValue());
            exp.setType(comboBox.getValue());
            /*exp.setUser(user);*/
            expenditureService.addExpend(exp);
            this.removeAll();
        });
        add(amountNumberfield, setDatePicker, comboBox, addExpendButton);
    }
}
