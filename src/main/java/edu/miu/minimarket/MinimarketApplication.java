package edu.miu.minimarket;

import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MinimarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinimarketApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_BUYER"));
			userService.saveRole(new Role(null,"ROLE_SELLER"));

			userService.saveUser(new User(null,"admin","admin","pass","12345666776","admin@gmail.com",true,new ArrayList<>()));
			userService.addRoleToUser("admin","ROLE_ADMIN");
		};
	}
}
