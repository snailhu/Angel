package angel.core.service.angel;

import java.util.Map;


public interface AngelReceiveOrderStatisticsService {

	/**总账单：截止上一个月的订单总量和总金额*/
	
	public Map<String,Float> getTotalOrderAndMoneyByLaseMonth();
	
	/**当月账单：截止至昨日的订单总量和订单总额*/
	
	public Map<String,Float> getTotalOrderAndMoneyByTomorrow();
}
