package com.gsn.gamems.service;

import com.gsn.gamems.exception.NotFoundException;
import com.gsn.gamems.model.persistence.Game;
import com.gsn.gamems.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	public Game getById(Long id){
		Game game = gameRepository.getById(id);
		if (game==null)	throw new NotFoundException("Game not found");
		return game;
	}

	public Page<Game> getAllGames(Pageable pageable){
		return gameRepository.findAllByActiveTrue(pageable);
	}
}
