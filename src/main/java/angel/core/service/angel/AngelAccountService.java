package angel.core.service.angel;

import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;

public interface AngelAccountService {

	/** ���ֻ� */

	public Integer bindPhone(String registration_Code, String phoneNum,
			String captcha);

	/**
	 * ��ʹ��֤��ȡ��֤�롣����̨����һ����֤�룬���ŷ��͸��û������ұ������֤���ڻ����У�����ʧЧʱ��Ϊ1���ӡ���
	 * 
	 * 
	 * */
	public void getCaptcha(String registration_Code, String phone);

	/** ��֤���� */

	public boolean validateAndSetpassword(String registration_Code, String phoneNum,
			String captcha, boolean evict,String password);

	/** �������� */

	public boolean setAngePassword(String registration_Code, String phoneNum,
			String captcha, boolean evict,String password);

	/**��������*/
	
	public void setPassword(String password);
		
	/**��ȡ��ǰ�û���ʹ*/
	
	public AngelStore  angelStore(User user); 
	
	
}
