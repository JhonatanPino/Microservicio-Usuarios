package com.pragma.microserviciousuarios.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleModelTest {

    @Test
    void constructor_ShouldInitializeFields_WhenValidArguments() {
        // Arrange
        String name = "Admin";
        String description = "Administrator role";

        // Act
        RoleModel roleModel = new RoleModel(1L, name, description);

        // Assert
        assertEquals(1L, roleModel.getId());
        assertEquals(name, roleModel.getName());
        assertEquals(description, roleModel.getDescription());
    }

    @Test
    void setName_ShouldUpdateName_WhenValidArgument() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        String newName = "User";

        // Act
        roleModel.setName(newName);

        // Assert
        assertEquals(newName, roleModel.getName());
    }

    @Test
    void setDescription_ShouldUpdateDescription_WhenValidArgument() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        String newDescription = "New description";

        // Act
        roleModel.setDescription(newDescription);

        // Assert
        assertEquals(newDescription, roleModel.getDescription());
    }

    @Test
    void setId_ShouldUpdateId() {
        // Arrange
        RoleModel roleModel = new RoleModel();
        Long newId = 2L;

        // Act
        roleModel.setId(newId);

        // Assert
        assertEquals(newId, roleModel.getId());
    }
}