package angel.core.service.common;

public interface XCaptchaService {

	public static final String CAPTCHA_PREFIX = "_c_";

	public static final String PHONE_PREFIX = "_p_";

	public static final String TIME_PREFIX = "_t_";

	/**
	 * ��ĳ�����뷢����֤�롣
	 * 
	 * */
	public void sendCaptcha(String phoneNum, int frequencySeconds);

	/**
	 * ��ĳ�����뷢����֤�롣
	 * 
	 * */
	public void sendCaptcha(String phoneNum);

	/**
	 * ������֤�롣
	 * 
	 * */
	public void saveCaptcha(String phoneNum, String captcha);

	/**
	 * ��֤�˺������֤�롣
	 * 
	 * */
	public boolean validate(String phoneNum, String captcha, boolean evict);

	
}
