package com.gsn.userms.model.dto.response;

import com.gsn.userms.model.persistence.Role;
import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO(Role role){
        this.id=role.getId();
        this.name=role.getName();
    }
}
