package com.szkaminski.demo.frontend.layouts;

import com.szkaminski.demo.backend.model.Type;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;

public class ExpanditureCreator extends VerticalLayout {

    public ExpanditureCreator() {
        NumberField amountNumberfield = new NumberField("set amount");
        DatePicker setDatePicker = new DatePicker("set date");
        ComboBox<Type> comboBox = new ComboBox<>();
        comboBox.setItems(Type.values());
        comboBox.setLabel("set type");

        add(amountNumberfield,setDatePicker, comboBox);
    }
}
