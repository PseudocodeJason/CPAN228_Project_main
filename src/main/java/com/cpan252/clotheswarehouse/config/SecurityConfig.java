package com.cpan252.clotheswarehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import com.cpan252.clotheswarehouse.model.User;
import com.cpan252.clotheswarehouse.repository.UserRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException(username);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                .authorizeHttpRequests()
                .requestMatchers(toH2Console()).permitAll()
                //Only allows Users withe the role ADMIN to access these pages urls
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                //Only allows Users with the role EMPLOYEE to access these pages urls
                .requestMatchers( "/add")
                .hasRole("EMPLOYEE")
                //Allows people with the role USER to these pages urls
                .requestMatchers("/clothlist")
                .hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/clothlist", true)
                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .headers()
                .frameOptions();

            http.csrf().disable();
            return http.build();
    }
}