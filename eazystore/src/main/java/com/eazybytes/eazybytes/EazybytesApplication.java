 package com.eazybytes.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class EazybytesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazybytesApplication.class, args);
	}

}
