package pe.nisum.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import pe.nisum.app.config.cors.EnableCors;
import pe.nisum.app.web.message.WebMessageSource;

@EnableCors
@SpringBootApplication
public class UserMain {

	public static void main(String[] args) {
		SpringApplication.run(UserMain.class);
	}

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		WebMessageSource messageSource = new WebMessageSource("default", 60, "classpath:i18n/messages", "classpath:i18n/messages-legacy");
		return messageSource;
	}

}
