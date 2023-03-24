package pe.nisum.app.web.security.basic.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "security.basic")
public class BasicSecurityProperties {

	@NotBlank
	private  String user;
	@NotBlank
	private String password;

}
