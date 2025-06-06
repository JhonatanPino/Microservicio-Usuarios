package com.pragma.microserviciousuarios.domain.usecases;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.domain.exceptions.InvalidCredentialsException;
import com.pragma.microserviciousuarios.domain.models.RoleModel;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationUseCase authenticationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticate_ValidCredentials_ReturnsUser() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        AuthenticationRequest request = new AuthenticationRequest(email, password);

        UserModel user = new UserModel(1L, "John", "Doe", "12345678",
                "+1234567890", LocalDate.of(1990, 1, 1), "test@example.com",
                "password123", new RoleModel(2L, "Admin", "Admin role"));
        user.setEmail(email);
        user.setPassword("encodedPassword");

        when(userPersistencePort.getUserByEmail(email)).thenReturn(user);
        when(passwordEncoder.matches(password, "encodedPassword")).thenReturn(true);

        // Act
        UserModel result = authenticationUseCase.authenticate(request);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(userPersistencePort, times(1)).getUserByEmail(email);
        verify(passwordEncoder, times(1)).matches(password, "encodedPassword");
    }

    @Test
    void authenticate_InvalidEmail_ThrowsInvalidCredentialsException() {
        // Arrange
        String email = "invalid@example.com";
        String password = "password";
        AuthenticationRequest request = new AuthenticationRequest(email, password);

        when(userPersistencePort.getUserByEmail(email)).thenReturn(null);

        // Act & Assert
        assertThrows(InvalidCredentialsException.class, () -> authenticationUseCase.authenticate(request));
        verify(userPersistencePort, times(1)).getUserByEmail(email);
        verify(passwordEncoder, never()).matches(anyString(), anyString());
    }

    @Test
    void authenticate_InvalidPassword_ThrowsInvalidCredentialsException() {
        // Arrange
        String email = "test@example.com";
        String password = "wrongPassword";
        AuthenticationRequest request = new AuthenticationRequest(email, password);

        UserModel user = new UserModel(1L, "John", "Doe", "12345678",
                "+1234567890", LocalDate.of(1990, 1, 1), "test@example.com",
                "password123", new RoleModel(2L, "Admin", "Admin role"));
        user.setEmail(email);
        user.setPassword("encodedPassword");

        when(userPersistencePort.getUserByEmail(email)).thenReturn(user);
        when(passwordEncoder.matches(password, "encodedPassword")).thenReturn(false);

        // Act & Assert
        assertThrows(InvalidCredentialsException.class, () -> authenticationUseCase.authenticate(request));
        verify(userPersistencePort, times(1)).getUserByEmail(email);
        verify(passwordEncoder, times(1)).matches(password, "encodedPassword");
    }
}
