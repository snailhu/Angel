package angel.core.Realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import angel.core.Exception.LockedAccountException;
import angel.core.Exception.UserNotFoundException;
import angel.core.domain.User;
import angel.core.domain.UserType;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.Customer;
import angel.core.service.UserService;

public class CustomeRealm extends AuthorizingRealm{

	@Resource
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  
		System.out.print(username);
        User user = userService.findUserByAccount(username);  
        if(user == null) {  
            throw new UserNotFoundException("没找到帐号  ");//没找到帐号  
        }  
        if(Boolean.TRUE.equals(user.getAccountNonLocked())) {  
            throw new LockedAccountException(); //帐号锁定  
        }  
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
                user.getAccount(), //用户名  
                user.getPassword(), //密码  
                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt  
                getName()  //realm name  
        ); 

        return authenticationInfo;  
	}

}
