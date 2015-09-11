package angel.core.service.common;

public interface XCaptchaService {

	public static final String CAPTCHA_PREFIX = "_c_";

	public static final String PHONE_PREFIX = "_p_";

	public static final String TIME_PREFIX = "_t_";

	/**
	 * 向某个号码发送验证码。
	 * 
	 * */
	public void sendCaptcha(String phoneNum, int frequencySeconds);

	/**
	 * 向某个号码发送验证码。
	 * 
	 * */
	public void sendCaptcha(String phoneNum);

	/**
	 * 保存验证码。
	 * 
	 * */
	public void saveCaptcha(String phoneNum, String captcha);

	/**
	 * 验证此号码的验证码。
	 * 
	 * */
	public boolean validate(String phoneNum, String captcha, boolean evict);

	
}
