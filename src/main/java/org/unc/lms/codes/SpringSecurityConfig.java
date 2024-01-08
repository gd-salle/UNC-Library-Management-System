package org.unc.lms.codes;

import static org.springframework.security.config.Customizer.withDefaults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.unc.lms.codes.services.UserService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);
	
	@Autowired
	public UserService userService; 
  
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
	}
	
	@Bean
	public AuthenticationManager authenticationManager (
			final AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager(); 
	}
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(withDefaults())
            .authorizeHttpRequests(authorize -> authorize
            	    .requestMatchers("/login", "/register", "/get-courses", "/css/**", "/img/**").permitAll()
            	    .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("studentId")
                .successForwardUrl("/LMSLandingPage")
                .failureUrl("/login?loginError=true"))
            .logout(logout -> logout
                .logoutSuccessUrl("/?logoutSuccess=true")
                .deleteCookies("JSESSIONID"))
            .exceptionHandling(exception -> exception
            	    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))

            .sessionManagement(session -> {
                session.maximumSessions(1);
                session.enableSessionUrlRewriting(true); 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            });

        return http.build();
	}
	

}
