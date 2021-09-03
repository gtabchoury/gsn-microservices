package com.gsn.userms.controller;

import com.gsn.userms.model.dto.response.UserDTO;
import com.gsn.userms.model.persistence.User;
import com.gsn.userms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;


	@GetMapping("/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam String email){
		User user = userService.findByEmail(email);
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
}
