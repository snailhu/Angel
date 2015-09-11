package angel.core.service.angel;

import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;

public interface AngelReceiveOrderService {

 	
	/**���ݶ���״̬ ��ȡ����*/
	public Page<UserOrder> getOrders(AngelStore store,String state,int page, int size);
	
	
	/**��ʱ�� ��ѯ�û�����*/
	
	public Page<UserOrder> getOrdersByTime(AngelStore store,String state,int page, int size,Date date);
	
	/**�޸��û�����״̬*/
	
	public void modifyOrderState(Long orderNum,String state);
	
	/**��ȡ��ֹ����Ϊֹ���û����������Լ��ܽ��*/
	
	public Map<Integer,Float> getTotalOrderAndMoney(AngelStore store,Date Date);
	
	/**���²�ѯ�����������Լ��ܽ��*/
	
	public Map<Integer,Float> getTotalOrderAndMoneyByMonth(AngelStore store,int month,int year);
	
    /**��ȡ��ֹ����Ϊֹ���û������ܽ��*/
	
	public Float getUserOrderTotalMoney(AngelStore store);
	
	/**��ʱ���ȡ�û��Ķ����б�*/
	
	public Page<UserOrder> getOrdersToday(int page, int size,Date date);
	
	/** ��ȡ�û���������*/
	
	public UserOrder getOrderDetail(long orderNum);
	
	
	
	
}
	