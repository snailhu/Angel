package angel.core.util;

import org.apache.shiro.SecurityUtils;

public class UserInfo {
	
	public static Object getCurrentUser(){
		return SecurityUtils.getSubject().getSession().getAttribute("currentUser");
	}
}
