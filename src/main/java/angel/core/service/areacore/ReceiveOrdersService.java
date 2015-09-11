package angel.core.service.areacore;

import java.util.List;

import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.areaCore.SendAreaCore;
import angel.core.domain.customer.UserArea;

/**
 * ���ͳ���������
 * @author Administrator
 *
 */

public interface ReceiveOrdersService {


	/**�鿴����������ʹ�����б�*/
	
	public List<AngelStoreOrder> getToadyOrders(SendAreaCore sendAreaCore);
	
	/**�鿴��ʹ��������*/
	
	public AngelStoreOrder getOrderDetail(Long orderNum);
	
	/**�鿴ĳ��С���������ʹ�Ķ���*/
	
	public List<AngelStoreOrder> getUserAreaOrders(UserArea userArea);
	
	
	
}
