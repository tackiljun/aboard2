package org.astro.aboard2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.astro.aboard2.**.mappers"})
public class Aboard2Application {

	public static void main(String[] args) {
		SpringApplication.run(Aboard2Application.class, args);
	}

}
