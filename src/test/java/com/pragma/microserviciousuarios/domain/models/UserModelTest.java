package com.pragma.microserviciousuarios.domain.models;

import com.pragma.microserviciousuarios.domain.exceptions.EmptyFieldException;
import com.pragma.microserviciousuarios.domain.exceptions.IdCannotBeNullException;
import com.pragma.microserviciousuarios.domain.exceptions.UserInvalidPhoneException;
import com.pragma.microserviciousuarios.domain.exceptions.UserMinorException;
import com.pragma.microserviciousuarios.domain.utils.constants.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    @Mock
    private UserModel userModel;
    private RoleModel roleModel;

    @BeforeEach
    void setUp() {
        roleModel = new RoleModel(1L, "Admin", "Administrator role");
        userModel = new UserModel(
                1L,
                "John",
                "Doe",
                "12345678",
                "+1234567890",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "password123",
                roleModel
        );
    }

    @Test
    void constructor_ShouldInitializeFields_WhenValidArguments() {
        assertEquals(1L, userModel.getId());
        assertEquals("John", userModel.getName());
        assertEquals("Doe", userModel.getLastName());
        assertEquals("12345678", userModel.getDocumentNumber());
        assertEquals("+1234567890", userModel.getPhone());
        assertEquals(LocalDate.of(1990, 1, 1), userModel.getBirthDate());
        assertEquals("john.doe@example.com", userModel.getEmail());
        assertEquals("password123", userModel.getPassword());
        assertEquals(roleModel, userModel.getRole());
    }

    @Test
    void getId_ShouldReturnId() {
        assertEquals(1L, userModel.getId());
    }

    @Test
    void setId_ShouldUpdateId() {
        userModel.setId(2L);
        assertEquals(2L, userModel.getId());
    }

    @Test
    void getName_ShouldReturnName() {
        assertEquals("John", userModel.getName());
    }

    @Test
    void setName_ShouldUpdateName() {
        userModel.setName("Jane");
        assertEquals("Jane", userModel.getName());
    }

    @Test
    void getLastName_ShouldReturnLastName() {
        assertEquals("Doe", userModel.getLastName());
    }

    @Test
    void setLastName_ShouldUpdateLastName() {
        userModel.setLastName("Smith");
        assertEquals("Smith", userModel.getLastName());
    }

    @Test
    void getDocumentNumber_ShouldReturnDocumentNumber() {
        assertEquals("12345678", userModel.getDocumentNumber());
    }

    @Test
    void setDocumentNumber_ShouldUpdateDocumentNumber() {
        userModel.setDocumentNumber("87654321");
        assertEquals("87654321", userModel.getDocumentNumber());
    }

    @Test
    void getPhone_ShouldReturnPhone() {
        assertEquals("+1234567890", userModel.getPhone());
    }

    @Test
    void setPhone_ShouldUpdatePhone() {
        userModel.setPhone("+0987654321");
        assertEquals("+0987654321", userModel.getPhone());
    }

    @Test
    void getBirthDate_ShouldReturnBirthDate() {
        assertEquals(LocalDate.of(1990, 1, 1), userModel.getBirthDate());
    }

    @Test
    void setBirthDate_ShouldUpdateBirthDate() {
        LocalDate newDate = LocalDate.of(2000, 1, 1);
        userModel.setBirthDate(newDate);
        assertEquals(newDate, userModel.getBirthDate());
    }

    @Test
    void getEmail_ShouldReturnEmail() {
        assertEquals("john.doe@example.com", userModel.getEmail());
    }

    @Test
    void setEmail_ShouldUpdateEmail() {
        userModel.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", userModel.getEmail());
    }

    @Test
    void getPassword_ShouldReturnPassword() {
        assertEquals("password123", userModel.getPassword());
    }

    @Test
    void setPassword_ShouldUpdatePassword() {
        userModel.setPassword("newpassword");
        assertEquals("newpassword", userModel.getPassword());
    }

    @Test
    void getRole_ShouldReturnRole() {
        assertEquals(roleModel, userModel.getRole());
    }

    @Test
    void setRole_ShouldUpdateRole() {
        RoleModel newRole = new RoleModel(2L, "User", "User role");
        userModel.setRole(newRole);
        assertEquals(newRole, userModel.getRole());
    }



}