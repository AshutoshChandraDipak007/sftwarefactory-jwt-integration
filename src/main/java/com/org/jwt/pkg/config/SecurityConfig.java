package com.org.jwt.pkg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.org.jwt.pkg.security.JWTAuthenticationFilter;
import com.org.jwt.pkg.security.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {
	
	    @Autowired
	    private JwtAuthenticationEntryPoint point;
	    
	    @Autowired
	    private JWTAuthenticationFilter filter;
	    
	    @SuppressWarnings("deprecation")
		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http,MvcRequestMatcher.Builder mvc) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeRequests()
	              //.requestMatchers("/test").authenticated() h2-console
	                .requestMatchers(mvc.pattern("/login")).permitAll()   //mvc.pattern("/login")
	                .requestMatchers(mvc.pattern("/h2-console")).permitAll()
	                .anyRequest().permitAll()
	              //  .authenticated()
	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    
		@Scope("prototype")
		@Bean
		MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
			return new MvcRequestMatcher.Builder(introspector);
		}
}
