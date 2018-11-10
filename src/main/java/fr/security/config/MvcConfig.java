package fr.security.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.security.entities.User;
import fr.security.services.IUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) // fait fonctionner l'annotation Securité sur les controller
public class MvcConfig extends WebSecurityConfigurerAdapter{
	
	//Injection de dépendance, pour redirection personnalisé après login
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Autowired
	private IUserService userService;

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		
		List<User> users = new ArrayList<>(userService.findAllUsers());
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			auth.inMemoryAuthentication().withUser(user.getName()).password(PasswordEncoder().encode(user.getPassword())).roles(user.getRole());
		}
		
		auth.inMemoryAuthentication().withUser("admin").password(PasswordEncoder().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("normal").password(PasswordEncoder().encode("123")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("premium").password(PasswordEncoder().encode("123")).roles("PREMIUM");
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/**", "/errors/**", "/logout", "/css/**", "/webjars/**", "/article/**", "/public/**").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("NORMAL")
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.loginPage("/login")
					.permitAll()
						.defaultSuccessUrl("/") //redirection après login
						 .successHandler(successHandler)
							.failureUrl("/faillogin") //redirection après echec de login
								.and()
			.logout()
				.permitAll();
		
		http.exceptionHandling().accessDeniedPage("/error/403");
	}

				
}
