package com.gsn.oauthms.service;

import com.gsn.oauthms.feignclients.UserFeignClient;
import com.gsn.oauthms.model.dto.response.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userFeignClient.findByEmail(username).getBody();
        if (user==null){
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: "+username);
        return user;
    }
}
