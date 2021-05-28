package com.justachallenge.criptos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
public class CriptosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptosApplication.class, args);
	}

}
