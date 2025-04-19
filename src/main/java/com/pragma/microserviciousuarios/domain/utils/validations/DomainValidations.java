package com.pragma.microserviciousuarios.domain.utils.validations;

import com.pragma.microserviciousuarios.domain.exceptions.*;
import com.pragma.microserviciousuarios.domain.models.RoleModel;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class DomainValidations {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Validations fields not Null and empty
    public static void isNullOrBlankValidationC(Long id, String name, String lastName, String documentNumber,
                                                String phone, LocalDate birthDate, String email, String password, RoleModel role){
        if (name == null || name.isBlank()){
            throw new EmptyFieldException();
        }
        if (lastName == null || lastName.isBlank()){
            throw new EmptyFieldException();
        }
        if (documentNumber == null || documentNumber.isBlank()){
            throw new EmptyFieldException();
        }
        if (phone == null || phone.isBlank()){
            throw new EmptyFieldException();
        }
        if (birthDate == null || birthDate.toString().isBlank()){
            throw new EmptyFieldException();
        }
        if (email == null || email.isBlank()){
            throw new EmptyFieldException();
        }
        if (password == null || password.isBlank()){
            throw new EmptyFieldException();
        }
        if (role == null || role.getId() == null || role.getId().toString().isBlank()) {
            throw new IdCannotBeNullException();
        }
    }
    //Validation for metods setters
    public static void isNullOrBlankValidationS(String field){
        if (field == null || field.isBlank()){
            throw new EmptyFieldException();
        }
    }
    public static void isNullOrBlankValidationI(RoleModel role){
        if (role == null || role.toString().isBlank()){
            throw new IdCannotBeNullException();
        }
    }

    // Validation for document number
    public static void isValidDocumentNumberValidation(String documentNumber) {
        boolean isValid = documentNumber.matches("\\d+");
        if (!isValid){
            throw new UserInvalidDocumenException();
        }
    }
    // Validation for phone
    public static void isValidPhoneValidation(String phone) {
        boolean isValid = phone.matches("\\+?\\d{7,12}");
        if (!isValid) {
            throw new UserInvalidPhoneException();
        }
    }
    // Validation for user age
    public static void isAdultValidation(LocalDate birthDate) {
        boolean isAdult = Period.between(birthDate, LocalDate.now()).getYears() >= 18;
        if (!isAdult){
            throw new UserMinorException();
        }
    }
    // Validation for email
    public static void isValidEmailValidation(String email) {
        boolean isValid = EMAIL_PATTERN.matcher(email).matches();
        if (!isValid) {
            throw new UserInvalidEmailException();
        }
    }
}
