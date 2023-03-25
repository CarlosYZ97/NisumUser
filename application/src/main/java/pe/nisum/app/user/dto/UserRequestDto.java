package pe.nisum.app.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDto {

	@ApiModelProperty(notes = "User name", example = "Juan Rodriguez")
	private String name;
	@ApiModelProperty(notes = "User email", example = "juqan2@rodriguez.org")
	private String email;
	@ApiModelProperty(notes = "User password", example = "hunter2")
	private String password;
	@ApiModelProperty(notes = "List phone")
	private List<Phone> phones;

	@Data
	public static class Phone {

		@ApiModelProperty(notes = "Phone number", example = "1234567")
		private String number;
		@ApiModelProperty(notes = "City Code", example = "1")
		private String cityCode;
		@ApiModelProperty(notes = "Country Code", example = "57")
		private String countryCode;

	}
}
