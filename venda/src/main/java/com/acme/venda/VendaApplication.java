package com.acme.venda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableFeignClients
public class VendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
	}

}
