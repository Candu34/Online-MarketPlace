package com.example.onlinemarketplace.configurations;

import com.example.onlinemarketplace.service.CustomUserDetailsService;
import com.example.onlinemarketplace.service.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Resource
    private final CustomUserDetailsService customUserDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/product/**", "images/**", "/registration")
                        .permitAll()
                        .anyRequest()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll().loginProcessingUrl("/login")
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    protected UserDetailsService configure(AuthenticationManagerBuilder auth) throws Exception {
        return customUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

}
