package com.shivam.login.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.shivam.login.service.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Autowired
//	private CustomAuthenticationProvider customAuthenticationProvider;
//
//	@Autowired
//	private RedAuthenticationProvider redAuthenticationProvider;

//	@Bean
//	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//		AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//		authManagerBuilder.authenticationProvider(customAuthenticationProvider);
////		authManagerBuilder.authenticationProvider(redAuthenticationProvider);
//
//		return authManagerBuilder.build();
//	}

    // @Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().sameOrigin();
//		http.csrf().disable().authorizeHttpRequests().requestMatchers("/**").hasRole("USER").and()
//				.httpBasic(withDefaults());
//		return http.build();
//	}

    @Bean
    public UserDetailsService userDetailsService() {
        return new JpaUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**");
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/error", "/login/oauth2", "/login*").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults());
        return http.build();
    }
}
