package com.example.servingwebcontent.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	// secret123
	private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";
	private static final String ENCODED_ADMIN_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/")
	        .antMatchers("/gruppen/**")
	        .antMatchers("/fahrten/**")
	        .antMatchers("/impressum")
	        .antMatchers("/datenschutz")
	        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin().permitAll().defaultSuccessUrl("/user", true)
			.and().logout().permitAll().logoutSuccessUrl("/");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
			.withUser("user").password(ENCODED_PASSWORD).roles("USER")
			.and()
			.withUser("admin").password(ENCODED_ADMIN_PASSWORD).roles("ADMIN");
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}