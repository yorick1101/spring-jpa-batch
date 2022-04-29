package me.yorick.poc.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringJpaBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBatchApplication.class, args);
	}

}
