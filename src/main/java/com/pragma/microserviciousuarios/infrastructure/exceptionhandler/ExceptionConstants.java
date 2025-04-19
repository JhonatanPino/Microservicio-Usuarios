package com.pragma.microserviciousuarios.infrastructure.exceptionhandler;

public class ExceptionConstants {
    // User
    public static final String USER_EXISTS_EXCEPTION = "The user already exists";
    public static final String USER_MINOR_MESSAGE = "The user cannot be a minor";
    public static final String USER_INVALID_DOCUMENT_MESSAGE = "The document must have only numeric characters";
    public static final String USER_INVALID_PHONE_MESSAGE = "Invalid phone number format";
    public static final String USER_INVALID_EMAIL_MESSAGE = "Invalid email format";

    // General
    //public static final String INVALID_PAGE_OR_SIZE = "Page and size must be greater than or equal to 0";
    public static final String FIELD_CANNOT_EMPTY_MESSAGE = "The field cannot be empty";
    public static final String ID_CANNOT_BE_NULL_MESSAGE = "The ID cannot be null";
}
