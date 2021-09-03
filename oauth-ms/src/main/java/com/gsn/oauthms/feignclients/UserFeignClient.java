package com.gsn.oauthms.feignclients;

import com.gsn.oauthms.model.dto.response.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-ms", path = "/users")
public interface UserFeignClient {
    @GetMapping("/search")
    ResponseEntity<UserDTO> findByEmail(@RequestParam String email);
}
