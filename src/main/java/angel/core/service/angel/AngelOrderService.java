package angel.core.service.angel;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;


import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;


/**
 * 
 * @author Administrator
 * 天使订单处理
 *
 */
public interface AngelOrderService {
	
	
	/**向区域中心下单*/

	public AngelStoreOrder placeAnOrder(AngelStore store,Map<String, Integer> items);
	
	/**天使提交订单*/
		
	public void submitAngelOrder(Long orderNum);
					
	/**按时间查询天使订货详情*/
	
	public Page<AngelStoreOrder> getAngelOrdersByTime(AngelStore store,int page, int size,Date date);
		
	
	/**获取截止今日为止订货总金额*/
	
	public Float getAngelOrderTotalMoney(AngelStore store);
}
