package angel.core.util;

import org.apache.commons.validator.routines.RegexValidator;

/**
 * 断言。
 * 
 * */
public class Assert {

	/* 参数格式验证 */

	private static final RegexValidator USERNAME_VALIDATOR = new RegexValidator(
			"^[a-zA-Z0-9]{1}[a-zA-Z0-9|-|_]{2,14}[a-zA-Z0-9]{1}$");

	private static final RegexValidator PASSWORD_VALIDATOR = new RegexValidator(
			"^[0-9a-zA-Z]{6,16}$");

	private static final RegexValidator EMAIL_VALIDATOR = new RegexValidator(
			"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

	private static final RegexValidator PHONE_VALIDATOR = new RegexValidator(
			"^(0|86|17951)?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$");

	/* 错误信息 */

	private static final String IS_NULL = "参数必须为空。";

	private static final String NOT_NULL = "参数不能为空。";

	private static final String HAS_LENGTH = "参数不能为空。";

	private static final String VALID_PHONENUMBER = "手机号码格式不正确。";

	private static final String VALID_EMAIL = "邮箱格式不正确。";

	private static final String VALID_USERNAME = "用户名格式不正确。";
	
	private static final String VALID_EQUALPASSWORD = "两次密码不一致。";

	private static final String VALID_PASSWORD = "密码格式不正确。";

	private static final String[] LENGTH_BETWEEN = { "参数长度必须介于", "与", "之间。" };

	private static final String[] LENGTH_LESSTHAN = { "参数长度必须小于", "。" };

	private static final String[] LENGTH_LARGERTHAN = { "参数长度必须大于", "。" };

	private static final String[] LENGTH_LESSTHAN_OR_EQUAL = { "参数长度必须小于等于",
			"。" };

	private static final String[] LENGTH_LARGERTHAN_OR_EQUAL = { "参数长度必须大于等于",
			"。" };

	public static void isNull(Object object, String msg) {
		if (object != null) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isNull(Object object) {
		isNull(object, IS_NULL);
	}

	public static void isNull(Object... objects) {
		for (Object o : objects) {
			isNull(o);
		}
	}

	public static void notNull(Object... objects) {
		for (Object o : objects) {
			notNull(o);
		}
	}

	public static void notNull(Object object, String msg) {
		if (object == null) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void notNull(Object object) {
		notNull(object, NOT_NULL);
	}

	public static void hasLength(String text, String msg) {
		if (text == null || text.length() <= 0) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void hasLength(String text) {
		hasLength(text, HAS_LENGTH);
	}

	public static void hasLength(String... texts) {
		for (String text : texts) {
			hasLength(text);
		}
	}

	/**
	 * 断言text的长度介于min，max之间。
	 * 
	 * @param text
	 * @param min
	 *            如果不需要最小值可传null值。
	 * @param max
	 *            如果不需要最大值可传null值。
	 * 
	 * */
	public static void lengthBetween(String text, Integer min, Integer max,
			String msg) {
		notNull(text);
		if (min == null && max == null) {
			return;
		}
		int length = text.length();
		if (min != null && max != null) {
			if (min > max) {
				throw new IllegalArgumentException("最小值不能大于最大值。");
			}
			if (length < min || length > max) {
				throw new IllegalArgumentException(msg);
			}
		}
		if (min == null && max != null) {
			if (length > max) {
				throw new IllegalArgumentException(msg);
			}
		}
		if (min != null && max == null) {
			if (length < min) {
				throw new IllegalArgumentException(msg);
			}
		}
	}

	/**
	 * 断言text的长度介于min，max之间。
	 * 
	 * @param text
	 * @param min
	 *            如果不需要最小值可传null值。
	 * @param max
	 *            如果不需要最大值可传null值。
	 * 
	 * */
	public static void lengthBetween(String text, Integer min, Integer max) {

		notNull(text);
		if (min == null && max == null) {
			return;
		}
		int length = text.length();
		if (min != null && max != null) {
			if (min > max) {
				throw new IllegalArgumentException("最小值不能大于最大值。");
			}
			if (length < min || length > max) {
				throw new IllegalArgumentException(LENGTH_BETWEEN[0] + min
						+ LENGTH_BETWEEN[1] + max + LENGTH_BETWEEN[2]);
			}
		}
		if (min == null && max != null) {
			if (length > max) {
				throw new IllegalArgumentException(LENGTH_LESSTHAN_OR_EQUAL[0]
						+ max + LENGTH_LESSTHAN_OR_EQUAL[1]);
			}
		}
		if (min != null && max == null) {
			if (length < min) {
				throw new IllegalArgumentException(
						LENGTH_LARGERTHAN_OR_EQUAL[0] + min
								+ LENGTH_LARGERTHAN_OR_EQUAL[1]);
			}
		}
	}

	/**
	 * 参数text长度必须小于参数a（不能等于），使用lengthBetween函数代替。
	 * 
	 * @see #lengthBetween(String, Integer, Integer, String)
	 * 
	 * */
	@Deprecated
	public static void lengthLessThan(String text, int a, String msg) {
		notNull(text);
		int length = text.length();
		if (length >= a) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * 参数text长度必须小于参数a（不能等于），使用lengthBetween函数代替。
	 * 
	 * @see #lengthBetween(String, Integer, Integer)
	 * 
	 * */
	@Deprecated
	public static void lengthLessThan(String text, int a) {
		lengthLessThan(text, a, LENGTH_LESSTHAN[0] + a + LENGTH_LESSTHAN[1]);
	}

	/**
	 * 参数text长度必须大于参数a（不能等于），使用lengthBetween函数代替。
	 * 
	 * @see #lengthBetween(String, Integer, Integer, String)
	 * 
	 * */
	@Deprecated
	public static void lengthLargerThan(String text, int a, String msg) {
		notNull(text);
		int length = text.length();
		if (length >= a) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * 参数text长度必须大于参数a（不能等于），使用lengthBetween函数代替。
	 * 
	 * @see #lengthBetween(String, Integer, Integer)
	 * 
	 * */
	@Deprecated
	public static void lengthLargerThan(String text, int a) {
		lengthLargerThan(text, a, LENGTH_LARGERTHAN[0] + a
				+ LENGTH_LARGERTHAN[1]);
	}

	public static void isvalidPhoneNumber(String number, String msg) {
		notNull(number);
		if (!PHONE_VALIDATOR.isValid(number)) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isvalidPhoneNumber(String number) {
		isvalidPhoneNumber(number, VALID_PHONENUMBER);
	}

	public static void isvalidEmail(String email, String msg) {
		notNull(email);
		if (!EMAIL_VALIDATOR.isValid(email)) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isvalidEmail(String email) {
		isvalidEmail(email, VALID_EMAIL);
	}

	public static void isvalidUsername(String username, String msg) {
		notNull(username);
		if (!USERNAME_VALIDATOR.isValid(username)) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isvalidUsername(String username) {
		isvalidUsername(username, VALID_USERNAME);
	}

	public static void isvalidPassword(String password, String msg) {
		notNull(password);
		if (!PASSWORD_VALIDATOR.isValid(password)) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isvalidPassword(String password) {
		isvalidPassword(password, VALID_PASSWORD);
	}
	
	public static void isEqualPassword(String password,String repeatPassword,String msg){
		notNull(password);
		notNull(repeatPassword);
		if (!(password.equals(repeatPassword))) {
			throw new IllegalArgumentException(msg);
		}
		}
	
	
	public static void isEqualPassword(String password,String repeatPassword){
		isEqualPassword(password,repeatPassword,VALID_EQUALPASSWORD);
	}
}
