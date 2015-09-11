package angel.core.service.angel.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;
import angel.core.repository.angel.AngelStoreRepository;
import angel.core.repository.customer.UserOrderRepository;
import angel.core.service.UserService;
import angel.core.service.angel.AngelReceiveOrderStatisticsService;
import angel.core.util.DateUtils;

public class AngelReceiveOrderStatisticsImpl implements AngelReceiveOrderStatisticsService {

	@Resource
	private UserOrderRepository userOrderRepository;
	@Resource
	private AngelStoreRepository angelStoreRepository;
	
	@Resource
	private UserService userService;

	
	private Map<String, Float> getTotalOrderAndMoney(
			List<UserOrder> userOrderList) {
		if(userOrderList.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		Float totalOrders =(float) userOrderList.size();
		Float totalMoney=0f;
		for(UserOrder uo:userOrderList){
			totalMoney+=uo.getTotalPrice();
		}
		Map<String, Float> orderAndMoney=new HashMap<String, Float>();
		orderAndMoney.put("totalOrders", totalOrders);
		orderAndMoney.put("totalMoney", totalMoney);
		return orderAndMoney;
	}
		
	@Override
	public Map<String, Float> getTotalOrderAndMoneyByLaseMonth() {
		AngelStore store=userService.getCurrentAngelUser();
		List<UserOrder> userOrderList=userOrderRepository.findOrderByLastMonth(store, DateUtils.getLastMonth());
		return getTotalOrderAndMoney(userOrderList);
	}


	@Override
	public Map<String, Float> getTotalOrderAndMoneyByTomorrow() {		
		AngelStore store=userService.getCurrentAngelUser();
		Date date=new Date();
		@SuppressWarnings("deprecation")
		List<UserOrder> userOrderList=userOrderRepository.findOrderByThisMonth(store, date.getYear() , date.getMonth(), date.getDate());
		return getTotalOrderAndMoney(userOrderList);
	}
}
