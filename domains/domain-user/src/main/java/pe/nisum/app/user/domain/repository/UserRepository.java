package pe.nisum.app.user.domain.repository;

import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;

public interface UserRepository {

	Boolean existEmail(String email);
	User save (UserInput userInput);

}
