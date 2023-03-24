package pe.nisum.app.user.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {

	private Integer id;
	private String number;
	private String cityCode;
	private String countryCode;
}
