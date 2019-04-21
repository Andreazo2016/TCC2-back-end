package com.ufc.projetoTcc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoTcc2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTcc2Application.class, args);
	}

}
