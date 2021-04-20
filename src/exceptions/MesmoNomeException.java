package exceptions;

public class MesmoNomeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MesmoNomeException() {
		super("Nome de curso já cadastrado. Por favor, tente novamente !");
	}
	
	public MesmoNomeException(String msg) {
		super(msg);
	}
}
