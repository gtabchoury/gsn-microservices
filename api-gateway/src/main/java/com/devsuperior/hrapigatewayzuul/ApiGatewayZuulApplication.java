package com.devsuperior.hrapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZuulApplication.class, args);
	}

}
