package angel.core.Exception;

public class LockedAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String message = "�û��˺��ѱ�����";

	public LockedAccountException() {
		super(message);
	}

	public LockedAccountException(String message) {
		super(message);
	}

	public LockedAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public LockedAccountException(Throwable cause) {
		super(cause);
	}

}
