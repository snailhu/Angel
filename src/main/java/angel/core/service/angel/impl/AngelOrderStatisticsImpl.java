package angel.core.service.angel.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;
import angel.core.repository.angel.AngelStoreOrderRepository;
import angel.core.repository.angel.AngelStoreRepository;
import angel.core.service.angel.AngelOrderStatisticsService;
import angel.core.util.DateUtils;

public class AngelOrderStatisticsImpl implements AngelOrderStatisticsService {
	@Resource
	private AngelStoreRepository angelStoreRepository;
	@Resource
	private AngelStoreOrderRepository angelStoreOrderRepository;
	
	@Override
	public Map<String, Float> getTotalAngelOrderAndMoneyByLastMonth() {
		String userAccount = (String)SecurityUtils.getSubject().getPrincipal();
		AngelStore store=angelStoreRepository.findByAccount(userAccount);
		List<AngelStoreOrder> angelStoreOrders=angelStoreOrderRepository.findByAngelStoreAndByLastMonth(store, DateUtils.getLastMonth());
		if(angelStoreOrders.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		Float totalOrders=(float)angelStoreOrders.size();
		Float totalMoney=0f;
		for(AngelStoreOrder aso:angelStoreOrders){
			totalMoney+=aso.getTotalPrice();
		}
		Map<String, Float> orderAndMoney=new HashMap<String, Float>();
		orderAndMoney.put("totalOrders", totalOrders);
		orderAndMoney.put("totalMoney", totalMoney);
		return orderAndMoney;
	}

}
