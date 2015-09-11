package angel.core.service;


import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.Customer;

/**
 * 对user的操作
 * @author Administrator
 *
 */
public interface UserService {
	
	/**根据用户名查找用户*/
	
	public User findUserByAccount(String account);
	
	/**获取当前天使的用户*/
	
	public AngelStore  getCurrentAngelUser();
	
	/**获取当前消费者用户*/
	
	public Customer  getCurrentCustomer();
}
