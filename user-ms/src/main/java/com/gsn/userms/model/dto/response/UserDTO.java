package com.gsn.userms.model.dto.response;

import com.gsn.userms.model.persistence.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.roles=user.getRoles().stream().map(RoleDTO::new).collect(Collectors.toSet());
    }
}
