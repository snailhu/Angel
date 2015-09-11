package angel.core.service.areacore;

import java.util.List;

import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.areaCore.SendAreaCore;
import angel.core.domain.customer.UserArea;

/**
 * 配送车订单管理
 * @author Administrator
 *
 */

public interface ReceiveOrdersService {


	/**查看今日配送天使订单列表*/
	
	public List<AngelStoreOrder> getToadyOrders(SendAreaCore sendAreaCore);
	
	/**查看天使订单详情*/
	
	public AngelStoreOrder getOrderDetail(Long orderNum);
	
	/**查看某个小区当天的天使的订单*/
	
	public List<AngelStoreOrder> getUserAreaOrders(UserArea userArea);
	
	
	
}
