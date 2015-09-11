package angel.core.controller.Exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import angel.core.Exception.BindNumExitedException;
import angel.core.Exception.DataIntegrityException;
import angel.core.Exception.InventoryException;
import angel.core.Exception.LockedAccountException;
import angel.core.Exception.RecordAcessDeniedException;
import angel.core.Exception.RecordExistedException;
import angel.core.Exception.RecordNotFoundException;
import angel.core.Exception.RelationNotMatchingException;
import angel.core.Exception.ResourceAccessException;
import angel.core.Exception.UnexpectedStateException;
import angel.core.Exception.UserExistedException;
import angel.core.Exception.UserNotFoundException;
import angel.core.Exception.UserNotLoginException;
import angel.core.Exception.ValidateTooFrequentlyException;
import angel.core.Exception.WrongCaptchaException;
import angel.core.pojo2json.message.ErrorCode;
import angel.core.pojo2json.message.JsonResponseBean;


/**
 * “Ï≥£¥¶¿Ì
 * 
 */
@ControllerAdvice
@RequestMapping(produces = "application/json;charset=utf-8")
public class ControllerExceptionAdvise {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseBody
	public String handlerRecordNotFoundException(RecordNotFoundException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.DATA_NOT_FOUND, ex.getMessage()).toJson();
	}
	
	@ExceptionHandler(LockedAccountException.class)
	@ResponseBody
	public String handlerLockedAccountException(LockedAccountException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ACCOUNT_LOCK, ex.getMessage()).toJson();
	}
	
	@ExceptionHandler(RelationNotMatchingException.class)
	@ResponseBody
	public String handlerRelationNotMatchingException(RelationNotMatchingException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ILLEGAL_ARGUMENT, ex.getMessage()).toJson();
	}

	@ExceptionHandler(UserNotLoginException.class)
	@ResponseBody
	public String handlerUserNotLoginException(UserNotLoginException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.NOT_LOGIN, ex.getMessage()).toJson();
	}

	@ExceptionHandler(RecordAcessDeniedException.class)
	@ResponseBody
	public String handlerRecordAcessDeniedException(RecordAcessDeniedException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ACCESS_DENIED, ex.getMessage()).toJson();
	}

	@ExceptionHandler(IOException.class)
	@ResponseBody
	public String handlerIOException(IOException ex) {
		ex.printStackTrace();
		return JsonResponseBean.getErrorResponse(ErrorCode.SERVER_ERROR, ex.getMessage()).toJson();
	}

	@ExceptionHandler(UnexpectedStateException.class)
	@ResponseBody
	public String handlerUnexpectedStateException(UnexpectedStateException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ERROR_STATE, ex.getMessage()).toJson();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public String handlerArgNonCorrectException(IllegalArgumentException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ILLEGAL_ARGUMENT, ex.getMessage()).toJson();
	}

	@ExceptionHandler(UserExistedException.class)
	@ResponseBody
	public String handlerUserExistedException(UserExistedException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ALLREADY_EXISTS, ex.getMessage()).toJson();
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public String handlerUserNotFoundException(UserNotFoundException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.NOT_FOUND, ex.getMessage()).toJson();
	}

	@ExceptionHandler(BindNumExitedException.class)
	@ResponseBody
	public String handlerBindNumExitedException(BindNumExitedException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ALLREADY_EXISTS, ex.getMessage()).toJson();
	}

	@ExceptionHandler(WrongCaptchaException.class)
	@ResponseBody
	public String handlerWrongCaptchaException(WrongCaptchaException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ILLEGAL_ARGUMENT, ex.getMessage()).toJson();
	}

	@ExceptionHandler(ResourceAccessException.class)
	@ResponseBody
	public String handlerResourceAccessException(ResourceAccessException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ACCESS_DENIED, ex.getMessage()).toJson();
	}

	@ExceptionHandler(DataIntegrityException.class)
	@ResponseBody
	public String handlerDataIntegrityException(DataIntegrityException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ERROR_STATE, ex.getMessage()).toJson();
	}

	@ExceptionHandler(RecordExistedException.class)
	@ResponseBody
	public String handlerRecordExistedException(RecordExistedException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ALLREADY_EXISTS, ex.getMessage()).toJson();
	}

	@ExceptionHandler(ValidateTooFrequentlyException.class)
	@ResponseBody
	public String handlerValidateTooFrequentlyException(ValidateTooFrequentlyException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ERROR_STATE, ex.getMessage()).toJson();
	}

	@ExceptionHandler(InventoryException.class)
	@ResponseBody
	public String handlerInventoryException(InventoryException ex) {
		return JsonResponseBean.getErrorResponse(ErrorCode.ERROR_STATE, ex.getMessage()).toJson();
	}


}
