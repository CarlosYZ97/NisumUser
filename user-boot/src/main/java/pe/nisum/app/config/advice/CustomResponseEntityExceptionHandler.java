package pe.nisum.app.config.advice;

import brave.Tracer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.nisum.app.web.WebResponseEntityExceptionHandler;
import pe.nisum.app.web.message.WebMessageSource;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends WebResponseEntityExceptionHandler {

	private final Tracer tracer;

	public CustomResponseEntityExceptionHandler(WebMessageSource webMessageSource, Tracer tracer) {
		super(webMessageSource);
		this.tracer = tracer;
	}

	@Override
	protected String getTrackingId() {
		return tracer.currentSpan().context().traceIdString();
	}

}
