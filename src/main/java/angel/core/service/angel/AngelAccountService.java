package angel.core.service.angel;

import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;

public interface AngelAccountService {

	/** 绑定手机 */

	public Integer bindPhone(String registration_Code, String phoneNum,
			String captcha);

	/**
	 * 天使验证获取验证码。（后台生成一个验证码，短信发送给用户，并且保存此验证码在缓存中，缓存失效时间为1分钟。）
	 * 
	 * 
	 * */
	public void getCaptcha(String registration_Code, String phone);

	/** 验证号码 */

	public boolean validateAndSetpassword(String registration_Code, String phoneNum,
			String captcha, boolean evict,String password);

	/** 设置密码 */

	public boolean setAngePassword(String registration_Code, String phoneNum,
			String captcha, boolean evict,String password);

	/**忘记密码*/
	
	public void setPassword(String password);
		
	/**获取当前用户天使*/
	
	public AngelStore  angelStore(User user); 
	
	
}
