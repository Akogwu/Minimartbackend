package edu.miu.minimarket.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //Security
//    @Bean
//    BCryptPasswordEncoder passwordEncoder(){
//        return  new BCryptPasswordEncoder();
//    }

}
