package com.gsn.groupms.model.persistence;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "groups")
public class Group extends BaseModel{

	public static final String TYPE_PRIVATE = "PRIVATE";
	public static final String TYPE_PUBLIC = "PUBLIC";

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="group_seq")
	@SequenceGenerator(name="group_seq", sequenceName="group_seq", allocationSize=1)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String type;

	@Column
	private Long gameId;

	public Boolean isPublic(){
		return getType()!=null && getType().equals(TYPE_PUBLIC);
	}

	public Boolean isPrivate(){
		return getType()!=null && getType().equals(TYPE_PRIVATE);
	}
}
