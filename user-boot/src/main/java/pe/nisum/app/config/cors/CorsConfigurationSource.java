package pe.nisum.app.config.cors;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pe.nisum.app.config.property.CorsProperties;

public class CorsConfigurationSource extends UrlBasedCorsConfigurationSource {

	public CorsConfigurationSource(CorsProperties corsProperties) {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedHeaders(corsProperties.getAllowedHeaders());
		configuration.setAllowedMethods(corsProperties.getAllowedMethods());
		configuration.setAllowedOrigins(corsProperties.getAllowedOrigins());
		configuration.setAllowCredentials(corsProperties.isAllowCredentials());
		registerCorsConfiguration(corsProperties.getPath(), configuration);
	}

}
