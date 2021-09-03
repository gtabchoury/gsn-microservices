package com.gsn.userms.model.persistence;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role{
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="role_seq")
	@SequenceGenerator(name="role_seq", sequenceName="role_seq", allocationSize=1)
	private Long id;

	@Column
	private String name;
}
