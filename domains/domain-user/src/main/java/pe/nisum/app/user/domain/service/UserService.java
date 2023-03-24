package pe.nisum.app.user.domain.service;

import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;

public interface UserService {

	User createUser(UserInput userInput);
}
