package com.pragma.microserviciousuarios.infrastructure.exceptionhandler;

import com.pragma.microserviciousuarios.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    // Field birthDate
    @ExceptionHandler(UserMinorException.class)
    public ResponseEntity<ExceptionResponse> handleUserMinorException(UserMinorException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_MINOR_MESSAGE,
                LocalDateTime.now()));
    }
    // Field documentNumber
    @ExceptionHandler(UserInvalidDocumenException.class)
    public ResponseEntity<ExceptionResponse> handleUserInvalidDocumenException(UserInvalidDocumenException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_INVALID_DOCUMENT_MESSAGE,
                LocalDateTime.now()));
    }
    // Field phone
    @ExceptionHandler(UserInvalidPhoneException.class)
    public ResponseEntity<ExceptionResponse> handleUserInvalidPhoneException(UserInvalidPhoneException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_INVALID_PHONE_MESSAGE,
                LocalDateTime.now()));
    }
    // Field email
    @ExceptionHandler(UserInvalidEmailException.class)
    public ResponseEntity<ExceptionResponse> handleUserInvalidEmailException(UserInvalidEmailException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_INVALID_EMAIL_MESSAGE,
                LocalDateTime.now()));
    }

    //General
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.FIELD_CANNOT_EMPTY_MESSAGE,
                LocalDateTime.now()));
    }
    @ExceptionHandler(IdCannotBeNullException.class)
    public ResponseEntity<ExceptionResponse> handleIdCannotBeNullException(IdCannotBeNullException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.ID_CANNOT_BE_NULL_MESSAGE,
                LocalDateTime.now()));
    }

    // User
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.USER_EXISTS_EXCEPTION,
                LocalDateTime.now()));
    }



}
