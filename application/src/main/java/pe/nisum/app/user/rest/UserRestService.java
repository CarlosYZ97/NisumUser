package pe.nisum.app.user.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nisum.app.user.dto.UserRequestDto;
import pe.nisum.app.user.dto.UserResponseDto;
import pe.nisum.app.user.service.UserApplicationService;

@RestController
@RequestMapping("api/external/user")
@RequiredArgsConstructor
public class UserRestService {

	private final UserApplicationService userApplicationService;

	@PostMapping
	@ApiOperation(value = "Creación de Usuario")
	@ApiResponses(value = {@ApiResponse(code = 200, response = String.class, message = "Procesado correctamente")})
	public UserResponseDto createUser(@ApiParam(value = "Usuario", required = true) @RequestBody UserRequestDto userRequestDto) {
		return userApplicationService.createUser(userRequestDto);
	}

}
