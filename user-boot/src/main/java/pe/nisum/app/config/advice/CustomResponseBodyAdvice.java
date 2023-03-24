package pe.nisum.app.config.advice;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import pe.nisum.app.web.WebResponseBodyAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomResponseBodyAdvice extends WebResponseBodyAdvice {

	public final Tracer tracer;
	@Override
	protected String getTrackingId() {
		return tracer.currentSpan().context().traceIdString();
	}

}
