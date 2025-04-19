package com.pragma.microserviciousuarios.infrastructure.endpoints.rest;

import com.pragma.microserviciousuarios.application.dto.request.SaveUserRequest;
import com.pragma.microserviciousuarios.application.dto.response.SaveUserResponse;
import com.pragma.microserviciousuarios.application.services.UserService;
import com.pragma.microserviciousuarios.domain.exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pragma.microserviciousuarios.commons.configuration.utils.Constants.*;
import static com.pragma.microserviciousuarios.infrastructure.exceptionhandler.ExceptionConstants.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Save a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATE, description = SAVE_USER_RESPONSE_MESSAGE),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = USER_EXISTS_EXCEPTION,
                    content = @Content(schema = @Schema(implementation = UserAlreadyExistsException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = FIELD_CANNOT_EMPTY_MESSAGE,
                    content = @Content(schema = @Schema(implementation = EmptyFieldException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = USER_INVALID_DOCUMENT_MESSAGE,
                    content = @Content(schema = @Schema(implementation = UserInvalidDocumenException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = USER_INVALID_PHONE_MESSAGE,
                    content = @Content(schema = @Schema(implementation = UserInvalidPhoneException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = USER_MINOR_MESSAGE,
                    content = @Content(schema = @Schema(implementation = UserMinorException.class))),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = USER_INVALID_EMAIL_MESSAGE,
                    content = @Content(schema = @Schema(implementation = UserInvalidEmailException.class))),
    })
    @PostMapping("/")
    public ResponseEntity<SaveUserResponse> createUser(@RequestBody SaveUserRequest saveUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(saveUserRequest));
    }
}


