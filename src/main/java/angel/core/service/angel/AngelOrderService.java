package angel.core.service.angel;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;


import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;


/**
 * 
 * @author Administrator
 * ��ʹ��������
 *
 */
public interface AngelOrderService {
	
	
	/**�����������µ�*/

	public AngelStoreOrder placeAnOrder(AngelStore store,Map<String, Integer> items);
	
	/**��ʹ�ύ����*/
		
	public void submitAngelOrder(Long orderNum);
					
	/**��ʱ���ѯ��ʹ��������*/
	
	public Page<AngelStoreOrder> getAngelOrdersByTime(AngelStore store,int page, int size,Date date);
		
	
	/**��ȡ��ֹ����Ϊֹ�����ܽ��*/
	
	public Float getAngelOrderTotalMoney(AngelStore store);
}
