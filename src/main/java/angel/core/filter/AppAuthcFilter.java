package angel.core.filter;


import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import angel.core.pojo2json.message.ErrorCode;
import angel.core.pojo2json.message.JsonResponseBean;



public class AppAuthcFilter  extends FormAuthenticationFilter  {
	
	private static final Logger log = LoggerFactory.getLogger(FormAuthenticationFilter.class);
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		  if (isAppLoginRequest(request, response)) {
	            if (isLoginSubmission(request, response)) {
	                if (log.isTraceEnabled()) {
	                    log.trace("Login submission detected.  Attempting to execute login.");
	                }
	                return executeLoginMyself(request, response);
	            } else {
	                if (log.isTraceEnabled()) {
	                    log.trace("Login page view.");
	                }
	                //allow them to see the login page ;)
	                return true;
	            }
	        } else {
	            if (log.isTraceEnabled()) {
	                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
	                        "Authentication url [" + getLoginUrl() + "]");
	            }
	            PrintWriter writer = response.getWriter();
	            response.setContentType("application/json; charset=utf-8");  
	            String message = JsonResponseBean.getErrorResponse(ErrorCode.NOT_LOGIN, "用户未登陆。").toJson();
	     		writer.write(message);
	     		writer.flush();
	     		writer.close();
	     		return false; 
	        }
	}
	
	
	
	protected boolean executeLoginMyself(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        if (token == null) {
            String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken " +
                    "must be created in order to execute a login attempt.";
            throw new IllegalStateException(msg);
        }
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            PrintWriter writer = response.getWriter();
            response.setContentType("application/json; charset=utf-8");  
            String message = JsonResponseBean.getSuccessResponse().toJson();
     		writer.write(message);
     		writer.flush();
     		writer.close();
     		return false; 
        } catch (AuthenticationException e) { 
    		String error = null;  
    		String message = null;
    		if(UnknownAccountException.class.getName().equals(e.getClass().getName())) {  			
    			error = "用户名/密码错误";  
    			message=JsonResponseBean.getErrorResponse(ErrorCode.ACCOUNT_ERROR, error).toJson();
    		} else if(IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {  
    			error = "用户名/密码错误";  
    			message=JsonResponseBean.getErrorResponse(ErrorCode.ACCOUNT_ERROR, error).toJson();
    		} else {  
    			error = "其他错";
    			message=JsonResponseBean.getErrorResponse(ErrorCode.ACCOUNT_ERROR, error).toJson();
    		} 
    		PrintWriter writer = response.getWriter();
    		response.setContentType("application/json; charset=utf-8");      		
    		writer.write(message);
    		writer.flush();
    		writer.close();
    		return false; 
        }
    }
		
	 protected boolean isAppLoginRequest(ServletRequest request, ServletResponse response) {
	        return pathsMatch("/app/login", request);
	    }
		   
	}

