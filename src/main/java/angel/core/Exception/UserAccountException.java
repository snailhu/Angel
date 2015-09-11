package angel.core.Exception;

public class UserAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String message = "ÓÃ»§´íÎó»òÃÜÂë´íÎó";

	public UserAccountException() {
		super(message);
	}

	public UserAccountException(String message) {
		super(message);
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountException(Throwable cause) {
		super(cause);
	}
}
