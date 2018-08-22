package br.com.bb.big.library.enums;

/**
 * Enum constraint violation
 * @author c1297467
 *
 */
public enum VelmaConstraintViolationEnum {

	 UQ_DS_CONSTRAINT_VELMA_IMAGEM("Essa imagem já existe no Velma.");

    private String message;

    private VelmaConstraintViolationEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
	
}