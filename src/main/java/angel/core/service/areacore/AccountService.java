package angel.core.service.areacore;

import java.util.List;

import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.areaCore.SendAreaCore;

/**
 * 区域车账号管理
 * @author Administrator
 *
 */

public interface AccountService {

	/**账号登录*/
	
	public void areaCarLogin (String username,String password);
	
	/**区域车获取验证码*/
	public void getCapatch (String phoneNum);
		
	/**设置密码*/
	
	public void setNewPassword(String phoneNum,String newPassword);
	
	
		
}
