package angel.core.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import angel.core.domain.User;

public class PasswordHelper {  
	private static String algorithmName = "md5";  
	private  static final int hashIterations = 1;  
	public static void encryptPassword(User user,String password,String salt) {  
		user.setSalt(new SecureRandomNumberGenerator().nextBytes().toHex());  
		String newPassword = new SimpleHash(  
				algorithmName,  
				password,  
				ByteSource.Util.bytes(salt),  
				hashIterations).toHex();  
		System.out.println(newPassword);
		user.setPassword(newPassword);  
		user.setSalt(salt);
	}  
}
