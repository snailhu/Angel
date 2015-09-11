package angel.core.controller.angel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import angel.core.Exception.RecordNotFoundException;
import angel.core.Exception.UserAccountException;
import angel.core.dto.DPage;
import angel.core.dto.customer.CustomerDto;
import angel.core.pojo2json.message.JsonResponseBean;
import angel.core.service.angel.AngelAccountService;
import angel.core.util.Assert;

/**天使的账户管理*/
@Controller
@RequestMapping(value = "/app", produces = "application/json;charset=utf-8")
public class AngelAccountController {
	
	@Resource 
	private AngelAccountService angelAccountService;
	
	
	/**用户登录*/
	@RequestMapping(value = "/login")  
	public String login(HttpServletRequest req) {  
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");  
		String error = null;  
		if(UnknownAccountException.class.getName().equals(exceptionClassName)) {  			
			error = "用户名/密码错误";  
			throw new UserAccountException(error);
		} else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {  
			error = "用户名/密码错误";  
			throw new UserAccountException(error);
		} else if(exceptionClassName != null) {  
			error = "其他错误：" + exceptionClassName;  
			throw new UserAccountException(error);
		}  
		return "login";  
	}  
		
	/**
	 * 验证手机号。
	 * 	
	 * @param number
	 *            要验证的手机号
	 * 
	 * */
	@RequestMapping(value = "/verifyNumber", method = { RequestMethod.POST })
	@ResponseBody
	public String verifyPhoneNumber(@RequestParam("number") String number,@RequestParam("Code") String code) {
		Assert.isvalidPhoneNumber(number);
		angelAccountService.getCaptcha(code, number);
		return JsonResponseBean.getSuccessResponse().toJson();
	}
	
	/**
	 * 获取验证码后 设置密码
	 */
	@RequestMapping(value = "/setPassword", method = { RequestMethod.POST })
	@ResponseBody
	public String setPasswrod(@RequestParam("captcha") String captcha,@RequestParam("password") String password,
	@RequestParam("number") String number,
	@RequestParam("repeatePwd") String repeatePwd,
	@RequestParam("code") String code)	
	{
		Assert.hasLength(captcha);
		Assert.isEqualPassword(password, repeatePwd);
		if(angelAccountService.setAngePassword(code, number, captcha, true, repeatePwd))
			{return JsonResponseBean.getSuccessResponse().toJson();}
		else throw new RecordNotFoundException("验证码校验错误");
	}
	
	
	
	
	
	/**返回json数据test*/
  	@RequestMapping(value="/validataUser.json",method = RequestMethod.POST)  
    @ResponseBody  
    public DPage<CustomerDto> validataUser(@RequestParam("number") String number,@RequestParam("Code") String code){  	  
  		System.out.println(number);
  		System.out.println(code);
        DPage<CustomerDto> dpage=new DPage<CustomerDto>();
        dpage.setTotalElements(200);
        dpage.setTotalPages(20);
        CustomerDto customerDto=new CustomerDto();
        customerDto.setPhoneNum("15862396507");
        customerDto.setUserName("huyajun");
        List<CustomerDto> userList=new ArrayList<CustomerDto>();
        userList.add(customerDto);
        dpage.setData(userList);
        return dpage;  
    }  
	
  	
  	/**返回json数据test*/
  	@RequestMapping(value="/validataUser.json",method = RequestMethod.GET)  
    @ResponseBody  
    public DPage<CustomerDto> validataUser(){  	
  		String username = (String)SecurityUtils.getSubject().getPrincipal();
  		System.out.println(username);
        DPage<CustomerDto> dpage=new DPage<CustomerDto>();
        dpage.setTotalElements(200);
        dpage.setTotalPages(20);
        CustomerDto customerDto=new CustomerDto();
        customerDto.setPhoneNum("15862396507");
        customerDto.setUserName("huyajun");
        List<CustomerDto> userList=new ArrayList<CustomerDto>();
        userList.add(customerDto);
        dpage.setData(userList);
        return dpage;  
    }  
  		
}
