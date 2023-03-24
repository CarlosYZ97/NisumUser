package pe.nisum.app.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;
import pe.nisum.app.user.dto.UserRequestDto;
import pe.nisum.app.user.dto.UserResponseDto;

import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	default UserResponseDto mapUserResponse(User user) {
		return UserResponseDto.builder()
			.id(user.getId())
			.created(user.getCreated())
			.modified(user.getModified())
			.lastLogin(user.getLastLogin())
			.token(user.getToken())
			.isActive(user.getIsActive())
			.build();
	}

	default UserInput mapUserInput(UserRequestDto userRequestDto) {

		return UserInput.builder()
			.name(userRequestDto.getName())
			.email(userRequestDto.getEmail())
			.password(userRequestDto.getPassword())
			.phones(userRequestDto.getPhones().stream().map(phone -> UserInput.Phone
					.builder()
					.number(phone.getNumber())
					.cityCode(phone.getCityCode())
					.countryCode(phone.getCountryCode())
					.build())
				.collect(Collectors.toList()))
			.build();
	}

}
