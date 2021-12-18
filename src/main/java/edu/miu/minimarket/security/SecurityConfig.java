package edu.miu.minimarket.security;

import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.security.filter.CustomAuthenticationFilter;
import edu.miu.minimarket.security.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
       // customAuthenticationFilter.setFilterProcessesUrl("/authenticate");

                http
                .cors()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/api/authenticate/**").permitAll()
                .antMatchers("/logout/**").permitAll()
                .antMatchers("/auth/api/register/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/products/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/buyers/**").hasAnyAuthority("ROLE_BUYER")
                .antMatchers("/sellers/**").hasAnyAuthority("ROLE_SELLER")
                .anyRequest().authenticated()
                .and()
                        .addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
                //.addFilter(customAuthenticationFilter)
                       // .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }


    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
     return super.authenticationManagerBean();
    }

}

