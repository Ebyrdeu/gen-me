package dev.ebyrdeu.genme.keygen.internal.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	SecurityFilterChain securityFilterChain(
		HttpSecurity http
	) throws Exception {

		http.cors(Customizer.withDefaults());
		http.csrf()


		return http.build();
	}
}
