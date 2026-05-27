package br.com.kafka.sistema_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SistemaKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaKafkaApplication.class, args);
	}
}
