package com.gsn.userms.service;

import com.gsn.userms.exception.NotFoundException;
import com.gsn.userms.model.persistence.User;
import com.gsn.userms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getById(Long id){
		User user = userRepository.getById(id);
		if (user==null)	throw new NotFoundException("Game not found");
		return user;
	}

	public User findByEmail(String email){
		User user = userRepository.findUserByEmail(email);
		if (user==null)	throw new NotFoundException("Game not found");
		return user;
	}
}
