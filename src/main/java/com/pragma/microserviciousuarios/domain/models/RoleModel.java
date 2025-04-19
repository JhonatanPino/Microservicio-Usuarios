package com.pragma.microserviciousuarios.domain.models;

import com.pragma.microserviciousuarios.domain.utils.constants.DomainConstants;
import com.pragma.microserviciousuarios.domain.utils.validations.DomainValidations;

import java.util.Objects;

public class RoleModel {
    private Long id;
    private String name;
    private String description;

    public RoleModel(Long id, String name, String description) {
        DomainValidations.isNullOrBlankValidationS(name);
        DomainValidations.isNullOrBlankValidationS(description);

        this.id = id;
        this.name =  Objects.requireNonNull(name, DomainConstants.ROLE_FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.ROLE_FIELD_DESCRIPTION_NULL_MESSAGE);
    }
    public RoleModel() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        DomainValidations.isNullOrBlankValidationS(name);
        this.name = Objects.requireNonNull(name, DomainConstants.ROLE_FIELD_NAME_NULL_MESSAGE);
    }
    public void setDescription(String description) {
        DomainValidations.isNullOrBlankValidationS(description);
        this.description = Objects.requireNonNull(description, DomainConstants.ROLE_FIELD_DESCRIPTION_NULL_MESSAGE);
    }
    public void setId(Long id) { this.id = id; }
}
