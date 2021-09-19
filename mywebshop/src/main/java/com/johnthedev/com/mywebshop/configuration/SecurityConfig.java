package com.johnthedev.com.mywebshop.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.jdbcAuthentication().dataSource(securityDataSource);
		System.out.println(auth.toString());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

//			.anonymous().principal("guest").authorities("GUEST_ROLE")
//			.and()
			.authorizeRequests()
			.antMatchers("/shoppingcart/list").hasRole("ADMIN")
			.antMatchers("/products/list**").permitAll()

			
//			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/products/list", true)
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
			.csrf().disable();
	}
	

		
}






