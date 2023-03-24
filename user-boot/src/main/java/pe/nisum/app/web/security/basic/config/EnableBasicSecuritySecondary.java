package pe.nisum.app.web.security.basic.config;

import org.springframework.context.annotation.Import;
import pe.nisum.app.web.security.basic.BasicWebSecurityConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BasicWebSecurityConfiguration.class)
public @interface EnableBasicSecuritySecondary {
}
