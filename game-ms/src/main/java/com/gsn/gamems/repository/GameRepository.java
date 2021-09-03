package com.gsn.gamems.repository;

import com.gsn.gamems.model.persistence.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GameRepository extends PagingAndSortingRepository<Game, Integer> {
    Game getById(Long id);
    Page<Game> findAllByActiveTrue(Pageable pageable);
    List<Game> findAllByActiveTrue();
}
