package pe.nisum.app.user.infraestructure.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;
import pe.nisum.app.user.domain.repository.UserRepository;
import pe.nisum.app.user.infraestructure.dao.entity.PhoneEntity;
import pe.nisum.app.user.infraestructure.dao.entity.UserEntity;
import pe.nisum.app.user.infraestructure.dao.mapper.PhoneMapper;
import pe.nisum.app.user.infraestructure.dao.mapper.UserMapper;
import pe.nisum.app.user.infraestructure.dao.repository.PhoneRepositoryJpa;
import pe.nisum.app.user.infraestructure.dao.repository.UserRepositoryJpa;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserRepositoryJpa userRepositoryJpa;
	private final PhoneRepositoryJpa phoneRepositoryJpa;

	@Override
	public Boolean existEmail(String email) {
		return userRepositoryJpa.existEmail(email);
	}

	@Override
	@Transactional
	public User save(UserInput userInput) {

		UserEntity userEntity = userRepositoryJpa.save(UserMapper.INSTANCE.mapUserEntity(userInput));

		this.savePhone(userInput, userEntity);

		return UserMapper.INSTANCE.mapUser(userEntity);
	}

	private void savePhone(UserInput userInput, UserEntity userEntity) {

		List<UserInput.Phone> phoneList = userInput.getPhones();
		List<PhoneEntity> phoneEntityList;

		if(phoneList.size() > 0) {
			phoneEntityList = phoneList.stream()
				.map(phone -> PhoneMapper.INSTANCE.mapPhoneEntity(phone, userEntity))
				.collect(Collectors.toList());
			phoneEntityList.forEach(phoneEntity -> phoneRepositoryJpa.save(phoneEntity));
		}

	}

}
