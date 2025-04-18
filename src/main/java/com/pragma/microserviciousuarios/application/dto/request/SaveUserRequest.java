package com.pragma.microserviciousuarios.application.dto.request;

import java.time.LocalDate;

import static com.pragma.microserviciousuarios.domain.utils.validations.DomainValidations.*;

public record SaveUserRequest(String name, String lastName, String documentNumber, String phone, LocalDate birthDate, String email, String password, Long idRole) {
    public SaveUserRequest {
        // Validations fields not Null and empty
        isNullOrBlankValidation(name);
        isNullOrBlankValidation(lastName);
        isNullOrBlankValidation(documentNumber);
        isNullOrBlankValidation(phone);
        isNullOrBlankValidation(birthDate.toString());
        isNullOrBlankValidation(email);
        isNullOrBlankValidation(password);
        isNullOrBlankValidation(idRole.toString());
        // Validation for user age
        isAdultValidation(birthDate);
        // Validation for document number
        isValidDocumentNumberValidation(documentNumber);
        // Validation for phone
        isValidPhoneValidation(phone);
        // Validation for email
        isValidEmailValidation(email);

    }
}

/*
1. La clave(encriptada con bcrypt), al almacenar la clave, debe ser cifrada, no al solicitar la data.
2. Se debe verificar estructura de email válida
3. El teléfono debe contener un máximo de 13 caracteres y puede contener el símbolo +. Ejemplo: +573005698325
4. El documento de identidad debe ser únicamente numérico..
5. El usuario debe ser mayor de edad"
 */
