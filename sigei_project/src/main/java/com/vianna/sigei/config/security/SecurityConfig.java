package com.vianna.sigei.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (auth) ->{
            auth.requestMatchers("/home", "/").permitAll()
                    .requestMatchers("/css/**","/img/**", "/js/**").permitAll()
                    .requestMatchers("/cliente/**").hasRole("FUNCIONARIO")
                    .anyRequest().authenticated();
        } ).formLogin( form ->{
            form.loginPage("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true").permitAll();
        }).logout( logout->{
            logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true).permitAll();
        });
        return http.build();
    }

}
