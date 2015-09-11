package angel.core.controller.angel;

import java.util.Date;



import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;
import angel.core.dto.DPage;
import angel.core.dto.customer.UserOrderDto;
import angel.core.pojo2json.DTOContext;
import angel.core.service.angel.AngelReceiveOrderService;
import angel.core.util.UserInfo;

import org.springframework.data.domain.Page;

/**
 * 天使管理用户订单
 * @author Administrator
 *
 */
@Controller
public class AngelReceiveOrderController {
	
	@Resource
	private AngelReceiveOrderService  angelReceiveOrderService;	
	/**
	 * 获取当日用户订单
	 */
	@ResponseBody
	@RequestMapping(value = "/customer/orders/bill", method = RequestMethod.GET)
	public DPage<UserOrderDto> getCustomerTodayOrdersBill(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {		
		Page<UserOrder> userOrders= angelReceiveOrderService.getOrdersToday(page, size, new Date());				
		return DTOContext.getConverter(UserOrderDto.class).convert(userOrders);
	}	
	
	
	 
}
