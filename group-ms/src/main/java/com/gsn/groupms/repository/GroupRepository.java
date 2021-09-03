package com.gsn.groupms.repository;

import com.gsn.groupms.model.persistence.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group getById(Long id);
    Page<Group> findAllByGameId(Long gameId, Pageable pageable);

}
