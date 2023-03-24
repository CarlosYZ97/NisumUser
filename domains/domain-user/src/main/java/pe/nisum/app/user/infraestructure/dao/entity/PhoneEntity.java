package pe.nisum.app.user.infraestructure.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHONE")
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_GEN")
	@SequenceGenerator(name = "PHONE_GEN", sequenceName = "PHONE_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NUMBER")
	private String number;

	@Column(name = "CITY_CODE")
	private String cityCode;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private UserEntity userEntity;
}
