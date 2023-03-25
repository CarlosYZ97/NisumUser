package pe.nisum.app.user.infraestructure.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.nisum.app.core.exception.ErrorConstant;
import pe.nisum.app.core.exception.WebException;
import pe.nisum.app.core.helper.Util;
import pe.nisum.app.core.security.encryption.AES;
import pe.nisum.app.user.domain.model.User;
import pe.nisum.app.user.domain.model.UserInput;
import pe.nisum.app.user.domain.repository.UserRepository;
import pe.nisum.app.user.domain.service.UserService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Value("${encryption.aes}")
	private byte[] userTokenKey;

	@Value("${security.password-pattern}")
	private String passwordPattern;

	@Value("${security.jwt.base64-secret}")
	private String secret;

	private final UserRepository userRepository;

	@Override
	public User createUser(UserInput userInput) {

		this.validateEmail(userInput.getEmail());
		this.validatePassword(userInput.getPassword());

		userInput.setPassword(this.generatePassword(userInput.getPassword()));
		userInput.setToken(this.createToken(userInput));

		return userRepository.save(userInput);
	}

	private String generatePassword(String password) {
		return AES.encrypt(userTokenKey, password);
	}

	private void validateEmail(String email) {

		if(!Util.patternEmail(email)) {
			throw new WebException(ErrorConstant.ERROR_FORMAT_EMAIL);
		}

		if(userRepository.existEmail(email)) {
			throw new WebException(ErrorConstant.ERROR_EMAIL_EXIST);
		}
	}

	private void validatePassword(String password) {

		if(!Util.patternPassword(password, passwordPattern)) {
			throw new WebException(ErrorConstant.ERROR_FORMAT_PASSWORD);
		}
	}

	private String createToken(UserInput userInput){

		final Instant now = Instant.now();

		return Jwts.builder()
			.setSubject(userInput.getEmail())
			.setIssuedAt(Date.from(now))
			.setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
			.signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret))
			.compact();
	}
}
