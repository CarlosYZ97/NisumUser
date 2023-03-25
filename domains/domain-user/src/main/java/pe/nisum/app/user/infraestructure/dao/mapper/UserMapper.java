package pe.nisum.app.user.infraestructure.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;
import pe.nisum.app.user.infraestructure.dao.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	default User mapUser(UserEntity userEntity) {
		return User.builder()
			.id(userEntity.getId().toString())
			.created(userEntity.getCreated())
			.isActive(userEntity.getIsActive())
			.modified(userEntity.getModified())
			.lastLogin(Objects.nonNull(userEntity.getLastLogin()) ? userEntity.getLastLogin() : userEntity.getCreated())
			.token(userEntity.getToken())
			.build();
	}

	default UserEntity mapUserEntity(UserInput userInput){

		UserEntity userEntity = new UserEntity();
		userEntity.setId(UUID.randomUUID());
		userEntity.setEmail(userInput.getEmail());
		userEntity.setName(userInput.getName());
		userEntity.setPassword(userInput.getPassword());
		userEntity.setCreated(LocalDateTime.now());
		userEntity.setModified(LocalDateTime.now());
		userEntity.setToken(userInput.getToken());
		userEntity.setIsActive(Boolean.TRUE);

		return userEntity;
	}

}
