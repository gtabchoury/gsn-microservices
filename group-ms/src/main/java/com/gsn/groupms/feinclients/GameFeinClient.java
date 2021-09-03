package com.gsn.groupms.feinclients;

import com.gsn.groupms.model.dto.response.GameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "game-ms", path = "/games")
public interface GameFeinClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<GameDTO> findById(@PathVariable Long id);
}
