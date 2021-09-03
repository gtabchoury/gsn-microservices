package com.gsn.userms.model.persistence;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User extends BaseModel{
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private Long id;

	@Column
	private String name;

	@Column
	private String username;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
}
