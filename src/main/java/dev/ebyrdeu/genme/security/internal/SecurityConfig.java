package dev.ebyrdeu.genme.security.internal;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(
		HttpSecurity http,
		CsrfTokenRequestHandler csrfTokenRequestHandler
	) throws Exception {

		http.cors(Customizer.withDefaults());

		http.csrf(csrf -> csrf
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.csrfTokenRequestHandler(csrfTokenRequestHandler)
		);

		http.httpBasic(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable);

		http.authorizeHttpRequests(req -> req.requestMatchers(
				"/",
				"/index.html",
				"/vite.svg",
				"/static/**",
				"/assets/**",
				"api/**"
			).permitAll()
		);

		return http.build();
	}
}
