package com.web.wsc_backend.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidationError extends StandardError {
    private List<FieldMessage> errors = new ArrayList<>();
    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}