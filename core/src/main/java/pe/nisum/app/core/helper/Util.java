package pe.nisum.app.core.helper;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class Util {

	public static Boolean patternEmail(String value) {
		Pattern pattern = Pattern.compile("^[A-Z0-9+_.-]+@[A-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

	public static Boolean patternPassword(String value, String passwordPattern) {
		Pattern pattern = Pattern.compile(passwordPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

}
