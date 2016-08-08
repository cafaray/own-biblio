package mx.ftc.com.biblio.bo.exception;

public class BOException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code = -1;
	
	public BOException(int code) {
		this.code = code;
		// TODO Auto-generated constructor stub
	}
		
	public BOException(String message, Throwable cause, int code) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BOException(String message, int code) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BOException(Throwable cause, int code) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	
	
}
