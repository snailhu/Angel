package angel.core.service;


import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.Customer;

/**
 * ��user�Ĳ���
 * @author Administrator
 *
 */
public interface UserService {
	
	/**�����û��������û�*/
	
	public User findUserByAccount(String account);
	
	/**��ȡ��ǰ��ʹ���û�*/
	
	public AngelStore  getCurrentAngelUser();
	
	/**��ȡ��ǰ�������û�*/
	
	public Customer  getCurrentCustomer();
}
