package com.gsn.groupms.model.dto.request;

import com.gsn.groupms.model.persistence.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CreateGroupDTO {
    @NotNull
    @Size(min=5)
    private String name;

    @NotNull
    @Size(min=5)
    private String description;

    @NotNull
    private Boolean isPublic;

    private Long gameId;

    public Group getModel(){
        Group group = new Group();
        group.setName(this.name);
        group.setDescription(this.description);
        group.setType(isPublic ? Group.TYPE_PUBLIC : Group.TYPE_PRIVATE);
        group.setGameId(this.gameId);
        return group;
    }
}
