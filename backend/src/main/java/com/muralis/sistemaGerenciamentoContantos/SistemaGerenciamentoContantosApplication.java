package com.muralis.sistemaGerenciamentoContantos;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaGerenciamentoContantosApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().directory("../").load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(SistemaGerenciamentoContantosApplication.class, args);
	}

}
