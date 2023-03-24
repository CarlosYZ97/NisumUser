package pe.nisum.app.user.service;

import pe.nisum.app.user.dto.UserRequestDto;
import pe.nisum.app.user.dto.UserResponseDto;

public interface UserApplicationService {

	UserResponseDto createUser(UserRequestDto userRequestDto);

}
