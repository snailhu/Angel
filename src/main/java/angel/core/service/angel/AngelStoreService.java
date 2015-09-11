package angel.core.service.angel;

import java.util.Date;

import org.springframework.data.domain.Page;

import angel.core.domain.common.Product;


public interface AngelStoreService {

	/**���ô���*/
	
	public void setTradingState(Date startDate, Date endDate);
	
	/**�޸Ĵ���״̬*/
	
	public void modifyTradingState(boolean state);
	
	/**��ȡ��Ʒ�б�*/
	
	public Page<Product> productList(int page, int size);
	
}
