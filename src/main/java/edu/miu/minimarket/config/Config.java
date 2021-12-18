package edu.miu.minimarket.config;

import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Configuration
public class Config {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //Security
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


}
