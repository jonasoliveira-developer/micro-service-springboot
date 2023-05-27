package br.com.jonas.microservices;

import br.com.jonas.microservices.domain.User;
import br.com.jonas.microservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApplication.class, args);
	}
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"Jonas Oliveira","jonas@email.com", "123", 20.0 );
		repository.save(user);
	}
}
