package com.johnthedev.com.mywebshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

			.authorizeRequests()
			.antMatchers("/shoppingcart/list").hasAuthority("CUSTOMER")
			.antMatchers("/orders/listorders").hasAuthority("ADMIN")
			.antMatchers("/customers/list").hasAuthority("ADMIN")
			.antMatchers("/products/list**").permitAll()

			
//			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
//				.loginPage("/login")
//				.loginProcessingUrl("/authenticateTheUser")
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






