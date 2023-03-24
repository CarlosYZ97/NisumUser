package pe.nisum.app.core.exception;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ErrorConstant {

	public static final String ERROR_EMAIL_EXIST = "validate.user.001";
	public static final String ERROR_FORMAT_EMAIL = "validate.user.002";
	public static final String ERROR_FORMAT_PASSWORD = "validate.user.003";
}
