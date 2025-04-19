package com.pragma.microserviciousuarios.domain.models;

import com.pragma.microserviciousuarios.domain.utils.constants.DomainConstants;

import java.time.LocalDate;
import java.util.Objects;

import static com.pragma.microserviciousuarios.domain.utils.validations.DomainValidations.*;

public class UserModel {
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
    private RoleModel role;

    public UserModel(Long id, String name, String lastName, String documentNumber,
                     String phone, LocalDate birthDate, String email, String password, RoleModel role) {

        isNullOrBlankValidationC(id, name, lastName, documentNumber, phone, birthDate, email, password, role);
        isValidDocumentNumberValidation(documentNumber);
        isValidPhoneValidation(phone);
        isAdultValidation(birthDate);
        isValidEmailValidation(email);

        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.USER_FIELD_NAME_NULL_MESSAGE);
        this.lastName = Objects.requireNonNull(lastName, DomainConstants.USER_FIELD_LAST_NAME_NULL_MESSAGE);
        this.documentNumber = Objects.requireNonNull(documentNumber, DomainConstants.USER_FIELD_DOCUMENT_NUMBER_NULL_MESSAGE);
        this.phone = Objects.requireNonNull(phone, DomainConstants.USER_FIELD_PHONE_NULL_MESSAGE);
        this.birthDate = Objects.requireNonNull(birthDate, DomainConstants.USER_FIELD_BIRTH_DATE_NULL_MESSAGE);
        this.email = Objects.requireNonNull(email, DomainConstants.USER_FIELD_EMAIL_NULL_MESSAGE);
        this.password = Objects.requireNonNull(password, DomainConstants.USER_FIELD_PASSWORD_NULL_MESSAGE);
        this.role = Objects.requireNonNull(role, DomainConstants.USER_FIELD_ROLE_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public String getPhone() {
        return phone;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public RoleModel getRole() {
        return role;
    }

    public void setName(String name) {
        isNullOrBlankValidationS(name);
        this.name = Objects.requireNonNull(name, DomainConstants.USER_FIELD_NAME_NULL_MESSAGE);
    }
    public void setLastName(String lastName) {
        isNullOrBlankValidationS(lastName);
        this.lastName = Objects.requireNonNull(lastName, DomainConstants.USER_FIELD_LAST_NAME_NULL_MESSAGE);
    }
    public void setDocumentNumber(String documentNumber) {
        isNullOrBlankValidationS(documentNumber);
        isValidDocumentNumberValidation(documentNumber);
        this.documentNumber = Objects.requireNonNull(documentNumber, DomainConstants.USER_FIELD_DOCUMENT_NUMBER_NULL_MESSAGE);
    }
    public void setPhone(String phone) {
        isNullOrBlankValidationS(phone);
        isValidPhoneValidation(phone);
        this.phone = Objects.requireNonNull(phone, DomainConstants.USER_FIELD_PHONE_NULL_MESSAGE);
    }
    public void setBirthDate(LocalDate birthDate) {
        isNullOrBlankValidationS(birthDate.toString());
        isAdultValidation(birthDate);
        this.birthDate = Objects.requireNonNull(birthDate, DomainConstants.USER_FIELD_BIRTH_DATE_NULL_MESSAGE);
    }
    public void setEmail(String email) {
        isNullOrBlankValidationS(email);
        this.email = Objects.requireNonNull(email, DomainConstants.USER_FIELD_EMAIL_NULL_MESSAGE);
    }
    public void setPassword(String password) {
        isNullOrBlankValidationS(password);
        this.password = Objects.requireNonNull(password, DomainConstants.USER_FIELD_PASSWORD_NULL_MESSAGE);
    }
    public void setRole(RoleModel role) {
        isNullOrBlankValidationI(role);
        this.role = Objects.requireNonNull(role, DomainConstants.USER_FIELD_ROLE_NULL_MESSAGE);
    }
    public void setId(Long id) { this.id = id; }
}
