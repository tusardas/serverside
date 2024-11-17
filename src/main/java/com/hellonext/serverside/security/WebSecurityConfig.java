package com.hellonext.serverside.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class WebSecurityConfig {
    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new GeneralUserService();
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new GeneralPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(
            httpSecuritySessionManagementConfigurer -> 
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        )
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            auth -> auth.requestMatchers("/images/**", "/css/**", "/js/**", "/WEB-INF/jsp/**").permitAll()
                        .anyRequest().authenticated())
        .formLogin(login -> login.loginPage("/login").successHandler(loginSuccessHandler).permitAll())
        .logout(logout -> logout.addLogoutHandler(logoutSuccessHandler).permitAll());

        return http.build();
    }
     
}