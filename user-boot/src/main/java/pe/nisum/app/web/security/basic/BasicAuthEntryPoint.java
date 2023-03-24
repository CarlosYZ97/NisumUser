package pe.nisum.app.web.security.basic;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicAuthEntryPoint extends BasicAuthenticationEntryPoint {

	public BasicAuthEntryPoint() {
	}

	public void commence(
		HttpServletRequest request,
		HttpServletResponse response,
		AuthenticationException authEx
	) throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + this.getRealmName() + "\"");
		response.setStatus(401);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 - " + authEx.getMessage());
	}

	public void afterPropertiesSet() {
		this.setRealmName("realm");
		super.afterPropertiesSet();
	}

}
