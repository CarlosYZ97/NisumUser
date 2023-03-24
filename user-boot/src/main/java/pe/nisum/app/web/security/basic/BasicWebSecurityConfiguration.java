package pe.nisum.app.web.security.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pe.nisum.app.web.security.basic.property.BasicSecurityProperties;

@Configuration
@ComponentScan(basePackageClasses = {BasicSecurityProperties.class})
public class BasicWebSecurityConfiguration {
}
