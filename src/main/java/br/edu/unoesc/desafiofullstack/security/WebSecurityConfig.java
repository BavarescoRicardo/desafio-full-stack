package br.edu.unoesc.desafiofullstack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf()
        .disable()
        .authorizeHttpRequests()
            .requestMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest()
        .authenticated()
        .and()
		.formLogin((form) -> form
			.loginPage("/login")
			.defaultSuccessUrl("/home", true)
			.permitAll()
		)
		.logout((logout) -> logout.permitAll());

		return http.build();
	}

	// @Bean
	// public UserDetailsService userDetailsService() {
	// 	UserDetails user = User.withUsername("bavaresco.ricardo.com")
	// 			.password(new BCryptPasswordEncoder().encode("admin"))
	// 			.roles("USER")
	// 			.build();
	// 	return new InMemoryUserDetailsManager(user);
	// }
// }	

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("bavaresco.ricardo.com")
				.password("admin")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
