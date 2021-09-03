package com.gsn.gamems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GameMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameMsApplication.class, args);
	}

}
