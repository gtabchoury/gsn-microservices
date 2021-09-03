package com.gsn.gamems.model.dto.response;

import com.gsn.gamems.model.persistence.Game;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private String name;
    private String description;
    private Double ratingScore;

    public GameDTO(Game game){
        this.id=game.getId();
        this.name=game.getName();
        this.description=game.getDescription();
        this.ratingScore=game.getRatingScore();
    }
}

