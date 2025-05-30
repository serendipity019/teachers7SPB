package gr.aueb.cf.teacherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TeachersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachersApplication.class, args);
	}

}
