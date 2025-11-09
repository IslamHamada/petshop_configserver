package com.islamhamada.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerBoot {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerBoot.class, args);
	}

}
