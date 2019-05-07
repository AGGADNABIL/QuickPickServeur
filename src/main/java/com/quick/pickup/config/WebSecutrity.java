package com.quick.pickup.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quick.pickup.service.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecutrity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);	
	}
	
    @Bean
    public UserDetailsService createUserDetailsService() {
        return new UserDetailsServiceImp();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().formLogin();
		http.authorizeRequests().antMatchers("/login/**","/registre/**").permitAll();
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/errors");
		http.logout().logoutSuccessUrl("/login");
		http.authorizeRequests().anyRequest().authenticated();	
	}
}
