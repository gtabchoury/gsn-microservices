package com.gsn.groupms.model.dto.response;

import com.gsn.groupms.model.persistence.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupDTO {
    private Long id;
    private String name;
    private String description;
    private String type;
    private GameDTO game;

    public GroupDTO(Group group, GameDTO game){
        this.id=group.getId();
        this.name=group.getName();
        this.description=group.getDescription();
        this.type=group.getType();
        this.game=game;
    }

    public GroupDTO(Group group){
        this.id=group.getId();
        this.name=group.getName();
        this.description=group.getDescription();
        this.type=group.getType();
    }
}
