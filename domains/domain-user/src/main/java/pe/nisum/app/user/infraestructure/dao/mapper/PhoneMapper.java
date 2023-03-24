package pe.nisum.app.user.infraestructure.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.nisum.app.user.domain.model.Phone;
import pe.nisum.app.user.domain.model.UserInput;
import pe.nisum.app.user.infraestructure.dao.entity.PhoneEntity;
import pe.nisum.app.user.infraestructure.dao.entity.UserEntity;

@Mapper
public interface PhoneMapper {

	PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

	default PhoneEntity mapPhoneEntity(UserInput.Phone phone, UserEntity userEntity){
		PhoneEntity phoneEntity = new PhoneEntity();

		phoneEntity.setNumber(phone.getNumber());
		phoneEntity.setCityCode(phone.getCityCode());
		phoneEntity.setCountryCode(phone.getCountryCode());
		phoneEntity.setUserEntity(userEntity);

		return phoneEntity;
	}

	default Phone mapPhone (PhoneEntity phoneEntity){
		return Phone.builder()
			.id(phoneEntity.getId())
			.number(phoneEntity.getNumber())
			.cityCode(phoneEntity.getCityCode())
			.countryCode(phoneEntity.getCountryCode())
			.build();
	}

}
