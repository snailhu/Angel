package angel.core.service.angel;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;

public interface AngelReceiveOrderService {

 	
	/**根据订单状态 获取订单*/
	public Page<UserOrder> getOrders(AngelStore store,String state,int page, int size);
	
	
	/**按时间 查询用户订单*/
	
	public Page<UserOrder> getOrdersByTime(AngelStore store,String state,int page, int size,Date date);
	
	/**修改用户订单状态*/
	
	public void modifyOrderState(Long orderNum,String state);
	
	/**获取截止今日为止的用户订单总量以及总金额*/
	
	public Map<Integer,Float> getTotalOrderAndMoney(AngelStore store,Date Date);
	
	/**按月查询户订单总量以及总金额*/
	
	public Map<Integer,Float> getTotalOrderAndMoneyByMonth(AngelStore store,int month,int year);
	
    /**获取截止今日为止的用户订单总金额*/
	
	public Float getUserOrderTotalMoney(AngelStore store);
	
	/**按时间获取用户的订单列表*/
	
	public Page<UserOrder> getOrdersToday(int page, int size,Date date);
	
	/** 获取用户订单详情*/
	
	public UserOrder getOrderDetail(long orderNum);
	
	
	
	
}
	