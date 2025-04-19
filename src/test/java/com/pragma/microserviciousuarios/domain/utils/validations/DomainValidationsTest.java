package com.pragma.microserviciousuarios.domain.utils.validations;

import com.pragma.microserviciousuarios.domain.exceptions.*;
import com.pragma.microserviciousuarios.domain.models.RoleModel;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DomainValidationsTest {

    @Mock
    private RoleModel roleModel;
    private UserModel userModel;

    @Test
    void isNullOrBlankValidationC_ShouldThrowException_WhenFieldIsNullOrBlank() {
        RoleModel role = new RoleModel(1L, "Admin", "Admin role");

        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, null, "Doe", "12345678", "+1234567890",
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", null, "12345678", "+1234567890",
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", "Doe", null, "+1234567890",
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", "Doe", "12345678", null,
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", "Doe", "12345678", "+1234567890",
                        null, "john.doe@example.com", "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", "Doe", "12345678", "+1234567890",
                        LocalDate.of(1990, 1, 1), null, "password123", role));
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationC(1L, "John", "Doe", "12345678", "+1234567890",
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", null, role));
        assertThrows(IdCannotBeNullException.class, () ->
                new UserModel(1L, "John", "Doe", "12345678", "+1234567890",
                        LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", null));
    }

    @Test
    void isNullOrBlankValidationS_ShouldThrowException_WhenFieldIsNullOrBlank() {
        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationS(null));

        assertThrows(EmptyFieldException.class, () ->
                DomainValidations.isNullOrBlankValidationS(""));
    }

    @Test
    void isValidDocumentNumberValidation_ShouldThrowException_WhenDocumentNumberIsInvalid() {
        assertThrows(UserInvalidDocumenException.class, () ->
                DomainValidations.isValidDocumentNumberValidation("ABC123"));

        assertThrows(UserInvalidDocumenException.class, () ->
                DomainValidations.isValidDocumentNumberValidation("123 456"));
    }

    @Test
    void isValidPhoneValidation_ShouldThrowException_WhenPhoneIsInvalid() {
        assertThrows(UserInvalidPhoneException.class, () ->
                DomainValidations.isValidPhoneValidation("12345"));

        assertThrows(UserInvalidPhoneException.class, () ->
                DomainValidations.isValidPhoneValidation("phone123"));
    }

    @Test
    void isAdultValidation_ShouldThrowException_WhenUserIsMinor() {
        assertThrows(UserMinorException.class, () ->
                DomainValidations.isAdultValidation(LocalDate.now().minusYears(17)));
    }

    @Test
    void isValidEmailValidation_ShouldThrowException_WhenEmailIsInvalid() {
        assertThrows(UserInvalidEmailException.class, () ->
                DomainValidations.isValidEmailValidation("invalid-email"));

        assertThrows(UserInvalidEmailException.class, () ->
                DomainValidations.isValidEmailValidation("user@domain"));
    }

    @Test
    void isNullOrBlankValidationI_ShouldThrowException_WhenRoleIsNull() {
        // Caso: RoleModel es nulo
        assertThrows(IdCannotBeNullException.class, () ->
                DomainValidations.isNullOrBlankValidationI(null));
    }

    @Test
    void isNullOrBlankValidationI_ShouldNotThrowException_WhenRoleIsValid() {
        // Caso: RoleModel válido
        RoleModel role = new RoleModel(1L, "Admin", "Admin role");
        DomainValidations.isNullOrBlankValidationI(role); // No debería lanzar excepción
    }
}