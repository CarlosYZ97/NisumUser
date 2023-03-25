package pe.nisum.app.user.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserInput {

	private String name;
	private String email;
	private String password;
	private String token;
	private List<Phone> phones;

	@Data
	@Builder
	public static class Phone {
		private String number;
		private String cityCode;
		private String countryCode;
	}

}
