package com.bagudu.appointSys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/assets/**").permitAll()
		.antMatchers("/index", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/assets/**").permitAll() //Allow Register Page without taking me to logging Page		
		.antMatchers("/user/book", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/assets/**").permitAll()	
		.antMatchers("/success", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/assets/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()		
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/book", true)
		.failureUrl("/login?error=true")
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();
		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}

}
