package com.gsn.groupms.service;

import com.gsn.groupms.feinclients.GameFeinClient;
import com.gsn.groupms.model.dto.request.CreateGroupDTO;
import com.gsn.groupms.model.dto.response.GameDTO;
import com.gsn.groupms.model.dto.response.GroupDTO;
import com.gsn.groupms.model.persistence.Group;
import com.gsn.groupms.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GameFeinClient gameFeinClient;

	public GroupDTO create(CreateGroupDTO groupRequest){
		Group group = groupRequest.getModel();

		GameDTO game = gameFeinClient.findById(group.getGameId()).getBody();

		group.setCreationDate(new Date());
		groupRepository.save(group);

		return new GroupDTO(group, game);
	}

	public Group getById(Long id){
		return groupRepository.getById(id);
	}

	public Page<Group> getByGame(Long gameId, Pageable pageable){
		return groupRepository.findAllByGameId(gameId, pageable);
	}

	public GameDTO getGame(Group group){
		return gameFeinClient.findById(group.getGameId()).getBody();
	}
}
