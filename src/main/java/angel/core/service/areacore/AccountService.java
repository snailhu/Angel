package angel.core.service.areacore;

import java.util.List;

import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.areaCore.SendAreaCore;

/**
 * �����˺Ź���
 * @author Administrator
 *
 */

public interface AccountService {

	/**�˺ŵ�¼*/
	
	public void areaCarLogin (String username,String password);
	
	/**���򳵻�ȡ��֤��*/
	public void getCapatch (String phoneNum);
		
	/**��������*/
	
	public void setNewPassword(String phoneNum,String newPassword);
	
	
		
}
