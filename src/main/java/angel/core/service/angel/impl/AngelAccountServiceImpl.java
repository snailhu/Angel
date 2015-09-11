package angel.core.service.angel.impl;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;
import angel.core.repository.UserRepository;
import angel.core.repository.angel.AngelStoreRepository;
import angel.core.service.UserService;
import angel.core.service.angel.AngelAccountService;
import angel.core.service.common.XCaptchaService;
import angel.core.util.PasswordHelper;

@Service
@Transactional
public class AngelAccountServiceImpl implements AngelAccountService {

	@Resource
	private AngelStoreRepository angelStoreRepository;	
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private XCaptchaService xCaptchaService;
	@Resource
	private UserService userService;
	
	@Override
	public void getCaptcha(String registration_Code,String phone) {
		 if(angelStoreRepository.findOneByCode(registration_Code)!=null){
			 xCaptchaService.sendCaptcha(phone);			 
		 }else{
			 throw new  RecordNotFoundException("¸Ã×¢²áÂë²»´æÔÚ");
		 }
		
	}

	@Override
	public boolean validateAndSetpassword(String registration_Code,String phoneNum, String captcha, boolean evict,String password) {
		if(xCaptchaService.validate(phoneNum, captcha, evict)){
			AngelStore angelStore = angelStoreRepository.findOneByCode(registration_Code);
			angelStore.getAngel_User().setPhone(phoneNum);
			angelStore.getAngel_User().setAccount(phoneNum);
			PasswordHelper.encryptPassword(angelStore.getAngel_User(), password,phoneNum);			
			angelStoreRepository.save(angelStore);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Integer bindPhone(String registration_Code, String phoneNum,
			String captcha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAngePassword(String registration_Code, String phoneNum,
			String captcha, boolean evict, String password) {
		if(validateAndSetpassword(registration_Code,phoneNum,captcha,evict,password))return true;
		else{return false;}
	}

	@Override
	public void setPassword(String password) {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.findUserByAccount(username);  
		user.setPassword(password);
		userRepository.save(user);
	}

	@Override
	public AngelStore angelStore(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
