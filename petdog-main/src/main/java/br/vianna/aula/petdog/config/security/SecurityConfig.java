package br.vianna.aula.petdog.config.security;

import br.vianna.aula.petdog.config.security.service.UserDetalhesService;
import br.vianna.aula.petdog.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetalhesService uServ;

    @Bean
    public PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager getAuth(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(uServ).passwordEncoder(getPassword())
                .and().build();
    }

//    @Bean
//    public UserDetailsService UserDetailsService(){
//        UserDetails admin = User
//                .withUsername("admin")
//                .password( getPassword().encode("123") )
//                .authorities("ROLE_ADMIN","ROLE_FUNCIONARIO","CAN_FILTER").build();
//        UserDetails admin1 = User
//                .withUsername("admin1")
//                .password( getPassword().encode("123") )
//                .authorities("ROLE_ADMIN","ROLE_FUNCIONARIO").build();
//
//        UserDetails cliente = User
//                .withUsername("cliente")
//                .password(getPassword().encode("123"))
//                .authorities("ROLE_CLIENTE").build();
//
//        return new InMemoryUserDetailsManager(admin, cliente, admin1);
//    }

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
