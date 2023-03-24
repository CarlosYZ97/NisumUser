package pe.nisum.app.web.security.basic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.nisum.app.web.security.basic.property.BasicSecurityProperties;

@Slf4j
@RequiredArgsConstructor
public class BasicSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	private final BasicSecurityProperties basicSecurityProperties;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser(basicSecurityProperties.getUser())
			.password(basicSecurityProperties.getPassword())
			.roles("BASIC")
			.and()
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.and()
			.httpBasic()
			.authenticationEntryPoint(new BasicAuthEntryPoint());
	}

}
