package com.gsn.groupms.controller;

import com.gsn.groupms.feinclients.GameFeinClient;
import com.gsn.groupms.model.dto.request.CreateGroupDTO;
import com.gsn.groupms.model.dto.response.GameDTO;
import com.gsn.groupms.model.dto.response.GroupDTO;
import com.gsn.groupms.model.persistence.Group;
import com.gsn.groupms.service.GroupService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupController extends BaseController{
	@Autowired
	private GroupService groupService;

	@Autowired
	private GameFeinClient gameFeinClient;

	@PostMapping("")
	public ResponseEntity<GroupDTO> create(HttpServletRequest req, @RequestBody @Valid CreateGroupDTO groupRequest) {
		GroupDTO group = groupService.create(groupRequest);
		return new ResponseEntity<>(group, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GroupDTO> get(HttpServletRequest req, @PathVariable Long id) {
		Group group = groupService.getById(id);
		GroupDTO groupDTO = new GroupDTO(group, gameFeinClient.findById(group.getGameId()).getBody());
		return new ResponseEntity<>(groupDTO, HttpStatus.OK);
	}

	@GetMapping("/game/{gameId}")
	public ResponseEntity<Map<String, Object>> getGroupsByGame(HttpServletRequest req, @PathVariable Long gameId) {
		GameDTO game = gameFeinClient.findById(gameId).getBody();
		Page<Group> pageGroups = groupService.getByGame(gameId, getPageable(req));
		List<GroupDTO> groups = pageGroups.getContent().stream().map(GroupDTO::new).collect(Collectors.toList());
		return new ResponseEntity<>(getPaginatedResponse(pageGroups, groups), HttpStatus.OK);
	}
}
