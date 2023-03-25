package pe.nisum.app.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.service.UserService;
import pe.nisum.app.user.dto.UserRequestDto;
import pe.nisum.app.user.dto.UserResponseDto;
import pe.nisum.app.user.mapper.UserMapper;
import pe.nisum.app.user.service.UserApplicationService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {

	private final UserService userService;

	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {

		User user = userService.createUser(UserMapper.INSTANCE.mapUserInput(
			userRequestDto));

		return UserMapper.INSTANCE.mapUserResponse(user);
	}

}
