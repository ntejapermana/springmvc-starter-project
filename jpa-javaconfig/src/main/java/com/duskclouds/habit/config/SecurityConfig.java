package com.duskclouds.habit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, "
					+ "password as credentials, true "
					+ "from users where username = ? and enabled = 1")               
			.authoritiesByUsernameQuery("select username as principal, "
					+ "authority as role from authorities where username = ?");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
		    	.antMatchers("/resources/**", "/").permitAll() 
			    .antMatchers("/dashboard").hasRole("USER")
		        .anyRequest().authenticated();
	    http.formLogin()
	    		.loginPage("/login")
	    		.successHandler(new SimpleUrlAuthenticationSuccessHandler("/dashboard"))
	    		.permitAll()
	        .and()
	        	.logout().logoutSuccessUrl("/")
	        	.permitAll();
	}
	
	
}
