package com.szkaminski.demo.frontend.validators;

import com.vaadin.flow.data.binder.ErrorLevel;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.AbstractValidator;


public class FieldValidator extends AbstractValidator<String> {

    private String errorMessage;

    public FieldValidator(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public ValidationResult apply(String s, ValueContext valueContext) {
        if (s.length() < 1) {
            return ValidationResult.create(errorMessage, ErrorLevel.ERROR);
        } else {
            return ValidationResult.ok();
        }
    }
}
