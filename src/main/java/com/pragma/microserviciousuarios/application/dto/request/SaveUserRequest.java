package com.pragma.microserviciousuarios.application.dto.request;

import java.time.LocalDate;

import static com.pragma.microserviciousuarios.domain.utils.validations.DomainValidations.*;

public record SaveUserRequest(String name, String lastName, String documentNumber, String phone, LocalDate birthDate, String email, String password, Long idRole) {
    public SaveUserRequest {
        // Validations fields not Null and empty
        isNullOrBlankValidationS(name);
        isNullOrBlankValidationS(lastName);
        isNullOrBlankValidationS(documentNumber);
        isNullOrBlankValidationS(phone);
        isNullOrBlankValidationS(birthDate.toString());
        isNullOrBlankValidationS(email);
        isNullOrBlankValidationS(password);
        isNullOrBlankValidationS(idRole.toString());
        // Validation for document number
        isValidDocumentNumberValidation(documentNumber);
        // Validation for phone
        isValidPhoneValidation(phone);
        // Validation for user age
        isAdultValidation(birthDate);
        // Validation for email
        isValidEmailValidation(email);

    }
}

