package com.gsn.oauthms.model.dto.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO implements UserDetails {
	private Long id;
	private String name;
	private String username;
	private String password;
	private String email;
	private Set<RoleDTO> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
