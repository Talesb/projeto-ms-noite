package com.acme.licenciamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableFeignClients
public class LicenciamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenciamentoApplication.class, args);
	}

}
