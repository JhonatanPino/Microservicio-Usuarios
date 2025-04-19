package com.pragma.microserviciousuarios.domain.usecases;

import com.pragma.microserviciousuarios.domain.exceptions.UserAlreadyExistsException;
import com.pragma.microserviciousuarios.domain.models.RoleModel;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    private UserPersistencePort userPersistencePort;
    private BCryptPasswordEncoder passwordEncoder;
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        userPersistencePort = mock(UserPersistencePort.class);
        passwordEncoder = mock(BCryptPasswordEncoder.class);
        userUseCase = new UserUseCase(userPersistencePort, passwordEncoder);
    }

    @Test
    void saveUser_ShouldThrowException_WhenUserAlreadyExists() {
        // Arrange
        UserModel existingUser = new UserModel(1L, "John", "Doe", "12345678",
                "+1234567890", LocalDate.of(1990, 1, 1), "test@example.com",
                "password123", new RoleModel(2L, "Admin", "Admin role"));
        existingUser.setEmail("test@example.com");

        when(userPersistencePort.getUserByEmail("test@example.com")).thenReturn(existingUser);

        UserModel newUser = new UserModel(1L, "John", "Doe", "12345678",
                "+1234567890", LocalDate.of(1990, 1, 1), "test@example.com",
                "password123", new RoleModel(2L, "Admin", "Admin role"));
        newUser.setEmail("test@example.com");

        // Act & Assert
        assertThrows(UserAlreadyExistsException.class, () -> userUseCase.saveUser(newUser));

        verify(userPersistencePort, times(1)).getUserByEmail("test@example.com");
        verify(userPersistencePort, never()).saveUser(any());
    }

    @Test
    void saveUser_ShouldSaveUser_WhenUserDoesNotExist() {
        // Arrange
        UserModel newUser = new UserModel(1L, "John", "Doe", "12345678",
                "+1234567890", LocalDate.of(1990, 1, 1), "test@example.com",
                "password123", new RoleModel(2L, "Admin", "Admin role"));
        newUser.setEmail("test@example.com");
        newUser.setPassword("password123");

        when(userPersistencePort.getUserByEmail("test@example.com")).thenReturn(null);
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");

        // Act
        userUseCase.saveUser(newUser);

        // Assert
        assertEquals("encodedPassword", newUser.getPassword());
        verify(userPersistencePort, times(1)).getUserByEmail("test@example.com");
        verify(passwordEncoder, times(1)).encode("password123");
        verify(userPersistencePort, times(1)).saveUser(newUser);
    }
}