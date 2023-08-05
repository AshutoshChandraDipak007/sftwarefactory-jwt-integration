package com.org.jwt.pkg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class JwtConfig {
	
	/*
	 * 	this bean is use to override the application properties credentials
	 *  this service use to fetch the user details whenever loadUserByName called	 
	 *    
	 */

	
//	@Bean
//	public UserDetailsService userDetilsService() {
//		UserDetails user = User.builder().username("User").password("Password").roles("Admin").build();
//		UserDetails user2 = User.builder().username("User2").password("Password2").roles("User").build();
//		return new InMemoryUserDetailsManager(user, user2);
//	}

	@Bean
	public UserDetailsService userDetilsService() {
		UserDetails user = User.builder().username("User").password(passwordEncoder().encode("Password")).roles("Admin").build();
		UserDetails user2 = User.builder().username("User2").password(passwordEncoder().encode("Password2")).roles("User").build();
		return new InMemoryUserDetailsManager(user, user2);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
