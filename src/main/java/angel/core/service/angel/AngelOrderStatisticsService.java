package angel.core.service.angel;

import java.util.Map;


public interface AngelOrderStatisticsService {
	
	/**总账单(截止上一个月的订货总量与订货总金额。)*/
	
	public Map<String ,Float> getTotalAngelOrderAndMoneyByLastMonth();
}
