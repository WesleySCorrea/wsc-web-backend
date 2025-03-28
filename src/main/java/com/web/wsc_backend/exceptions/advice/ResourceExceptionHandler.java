package com.web.wsc_backend.exceptions.advice;

import com.web.wsc_backend.exceptions.FieldMessage;
import com.web.wsc_backend.exceptions.ValidationError;
import com.web.wsc_backend.exceptions.runtime.PersistFailedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Collections;

@EnableWebMvc
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersistFailedException.class)
    public ResponseEntity<Object> persistFailedException(PersistFailedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setErrorCode(status.name());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());
        err.setErrors(Collections.singletonList(new FieldMessage("PersistFailedException",e.getMessage())));
        return ResponseEntity.status(status).body(err);
    }
}
