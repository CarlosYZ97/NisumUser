package pe.nisum.app.core.security.property;

public interface EncryptingConfig {

	byte[] getAESKey();

	byte[] getDESKey();

	byte[] getMstkenc();

}
