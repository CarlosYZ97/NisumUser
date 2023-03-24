package pe.nisum.app.core.security.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.nisum.app.core.security.property.EncryptingConfig;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {

	private static final Logger log = LoggerFactory.getLogger(AES.class);

	public static String encrypt(EncryptingConfig encryptingConfig, String value) {
		return encrypt(encryptingConfig.getAESKey(), value);
	}

	public static String encrypt(String AESKey, String value) {
		return encrypt(AESKey.getBytes(), value);
	}

	public static String encrypt(byte[] AESKey, String value) {
		SecretKeySpec key = new SecretKeySpec(AESKey, "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(1, key);
			byte[] campoCifrado = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(campoCifrado);
		} catch (BadPaddingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
		         NoSuchAlgorithmException var5) {
			log.error("Error encrypting value {} with AES", value, var5);
			return "";
		}
	}

	public static String decrypt(String AESKey, String value) {
		return decrypt(AESKey.getBytes(), value);
	}

	public static String decrypt(EncryptingConfig encryptingConfig, String value) {
		return decrypt(encryptingConfig.getAESKey(), value);
	}

	public static String decrypt(byte[] AESKey, String value) {
		SecretKeySpec key = new SecretKeySpec(AESKey, "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(2, key);
			byte[] data = Base64.getDecoder().decode(value);
			byte[] decryptedData = cipher.doFinal(data);
			return new String(decryptedData, StandardCharsets.UTF_8);
		} catch (BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException var6) {
			log.error("Error encrypting value {} with AES", value, var6);
			return "";
		}
	}

	private AES() {
	}

}
