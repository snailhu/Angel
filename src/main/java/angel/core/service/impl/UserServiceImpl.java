package angel.core.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.Customer;
import angel.core.repository.UserRepository;
import angel.core.repository.angel.AngelStoreRepository;
import angel.core.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;
	@Resource
	private AngelStoreRepository angelStoreRepository;

	@Override
	public User findUserByAccount(String account) {
		User user=userRepository.findUserByAccount(account);
		if(user==null)throw new RecordNotFoundException("没有找到该用户");
		else{
			return user;
		}		
	}

	@Override
	public AngelStore getCurrentAngelUser() {
		String userAccount = (String)SecurityUtils.getSubject().getPrincipal();
		AngelStore store=angelStoreRepository.findByAccount(userAccount);
		if(store==null)throw new RecordNotFoundException("没有找到该用户");
		else{
			return store;
		}				
	}

	@Override
	public Customer getCurrentCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
