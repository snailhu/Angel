package angel.core.service.angel;

import java.util.Map;


public interface AngelReceiveOrderStatisticsService {

	/**���˵�����ֹ��һ���µĶ����������ܽ��*/
	
	public Map<String,Float> getTotalOrderAndMoneyByLaseMonth();
	
	/**�����˵�����ֹ�����յĶ��������Ͷ����ܶ�*/
	
	public Map<String,Float> getTotalOrderAndMoneyByTomorrow();
}
