package angel.core.service.angel;

import java.util.Date;

import org.springframework.data.domain.Page;

import angel.core.domain.common.Product;


public interface AngelStoreService {

	/**设置打烊*/
	
	public void setTradingState(Date startDate, Date endDate);
	
	/**修改打烊状态*/
	
	public void modifyTradingState(boolean state);
	
	/**获取商品列表*/
	
	public Page<Product> productList(int page, int size);
	
}
