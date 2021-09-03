package com.gsn.gamems.controller;

import com.gsn.gamems.model.dto.response.GameDTO;
import com.gsn.gamems.model.persistence.Game;
import com.gsn.gamems.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
public class GameController extends BaseController{
	@Autowired
	private GameService gameService;

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getAll(HttpServletRequest req){
		Page<Game> pageGames = gameService.getAllGames(getPageable(req));
		List<GameDTO> games = pageGames.getContent().stream().map(GameDTO::new).collect(Collectors.toList());
		return new ResponseEntity<>(getPaginatedResponse(pageGames, games), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> getById(@PathVariable Long id){
		Game game = gameService.getById(id);
		return new ResponseEntity<>(new GameDTO(game), HttpStatus.OK);
	}
}
