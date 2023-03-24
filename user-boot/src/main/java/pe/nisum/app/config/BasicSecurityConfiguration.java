package pe.nisum.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import pe.nisum.app.web.security.basic.BasicSecurityConfigurerAdapter;
import pe.nisum.app.web.security.basic.config.EnableBasicSecuritySecondary;
import pe.nisum.app.web.security.basic.property.BasicSecurityProperties;

@Order(99)
@Configuration
@EnableBasicSecuritySecondary
public class BasicSecurityConfiguration extends BasicSecurityConfigurerAdapter {

	public BasicSecurityConfiguration(BasicSecurityProperties basicSecurityProperties) {
		super(basicSecurityProperties);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
		http.antMatcher("/api/external/**")
			.authorizeRequests()
			.antMatchers("/management/**").permitAll()
			.antMatchers("/actuator/**").permitAll()
			.anyRequest().authenticated();
	}

}
