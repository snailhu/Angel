package angel.core.service.customer;

import angel.core.dto.customer.CustomerDto;


public interface CustomerAccountService {

	/**
	 * 获取我的账户信息。
	 * 
	 * */
	public CustomerDto getInfo();

	/**
	 * 注册。
	 * 
	 * */
	public void register(String username, String password);	

	/**
	 * 验证手机号。
	 * 
	 * @param number
	 *            要验证的手机号
	 * 
	 * */
	public void varifyPhoneNumber(String phoneNum);

	/**
	 * 绑定手机号。（后台生成一个验证码，短信发送到此号码。）
	 * 
	 * @param captcha
	 *            验证码。
	 * 
	 * */
	public void bindPhoneNumber(String captcha);

	/**
	 * 获取验证码。（后台生成一个验证码，短信发送给用户，并且保存此验证码在缓存中，缓存失效时间为1分钟。）
	 * 
	 * @param username
	 *            登陆用户名（操作者）
	 * 
	 * */
	public void getCaptcha();

	/**
	 * 解除绑定。
	 * 
	 * */
	public void unbindPhoneNumber(String captcha);

	/**
	 * 找回密码的时候通过绑定手机号发送验证码。
	 * 
	 * @param phone
	 * 
	 * */
	public void postCaptcha(String phone);

	/**
	 * 通过绑定手机号重置密码。
	 * 
	 * */
	public void resetPassword(String phone, String captcha, String password);

	/**
	 * 修改密码。
	 * 
	 * */
	public void editPassword(String password, String newPassword);
}
