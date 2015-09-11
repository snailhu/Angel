package angel.core.service.angel.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;
import angel.core.domain.customer.UserOrderState;
import angel.core.repository.angel.AngelStoreOrderItemsRepository;
import angel.core.repository.angel.AngelStoreOrderRepository;
import angel.core.repository.angel.AngelStoreRepository;
import angel.core.repository.common.ProductRepository;
import angel.core.repository.customer.UserOrderRepository;
import angel.core.service.angel.AngelReceiveOrderService;
import angel.core.util.DateUtils;

@Service
@Transactional
public class AngelReceiveOrderServiceImpl implements AngelReceiveOrderService {
	
	@Resource
	private UserOrderRepository userOrderRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private AngelStoreOrderItemsRepository angelStoreOrderItemsRepository;
	@Resource
	private AngelStoreOrderRepository angelStoreOrderRepository;	
	@Resource
	private AngelStoreRepository angelStoreRepository;
	
	private Pageable getPageable(int page, int size) {
		if (page <= 0)
			page = 1;
		if (size <= 0) {
			size = 20;
		}
		return new PageRequest(page - 1, size);
	}	

	@Override
	public Page<UserOrder> getOrders(AngelStore store, String state,int page, int size) {
		UserOrderState  userOrderState=UserOrderState.parseUserOrderState(state);		
		Page<UserOrder> userOrderPage= userOrderRepository.findByState(userOrderState, getPageable(page,size));		
		return userOrderPage;
	}

	@Override
	public Page<UserOrder> getOrdersByTime(AngelStore store, String state,
			int page, int size, Date date) {
		UserOrderState  userOrderState=UserOrderState.parseUserOrderState(state);
		Page<UserOrder> userOrderPage= userOrderRepository.findByDate(userOrderState, getPageable(page,size),date);		
		return userOrderPage;
	}

	@Override
	public void modifyOrderState(Long orderNum,String state) {
			
		UserOrder userOrder=userOrderRepository.findByOrderNum(orderNum);
		if(userOrder!=null){
			UserOrderState  userOrderState=UserOrderState.parseUserOrderState(state);	
			userOrder.setState(userOrderState);
			userOrderRepository.save(userOrder);
		}else{
			throw new RecordNotFoundException("该订单不存在");
		}
	}
	
	@Override
	public Map<Integer, Float> getTotalOrderAndMoney(AngelStore store,Date date) {
		List<UserOrder> userOrderList=userOrderRepository.findOrderByStore(store);
		if(userOrderList.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		int totalOrders =userOrderList.size();
		Float totalMoney=0f;
		for(UserOrder uo:userOrderList){
			totalMoney+=uo.getTotalPrice();
		}
		Map<Integer, Float> orderAndMoney=new HashMap<Integer, Float>();
		orderAndMoney.put(totalOrders, totalMoney);
		return orderAndMoney;
	}

	@Override
	public Map<Integer, Float> getTotalOrderAndMoneyByMonth(AngelStore store,
			int month,int year) {
		List<UserOrder> userOrderList=userOrderRepository.findOrderByMonth(store, month,year);
		if(userOrderList.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		int totalOrders =userOrderList.size();
		Float totalMoney=0f;
		for(UserOrder uo:userOrderList){
			totalMoney+=uo.getTotalPrice();
		}
		Map<Integer, Float> orderAndMoney=new HashMap<Integer, Float>();
		orderAndMoney.put(totalOrders, totalMoney);
		return orderAndMoney;
	}

	@Override
	public Float getUserOrderTotalMoney(AngelStore store) {
		List<UserOrder> userOrderList=userOrderRepository.findOrderByStore(store);
		if(userOrderList.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		Float totalMoney=0f;
		for(UserOrder uo:userOrderList){
			totalMoney+=uo.getTotalPrice();
		}
		return totalMoney;
	}

	@Override
	public Page<UserOrder> getOrdersToday(int page, int size,Date date) {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		AngelStore store = angelStoreRepository.findByAccount(username);
		Page<UserOrder> userOrders = userOrderRepository.findOrderToday(store, DateUtils.yyyMMdd(), getPageable(page,size));
		if(userOrders!=null){
			return userOrders;
		}else{
			throw new RecordNotFoundException("今天暂时没有订单");
		}		
	}

	@Override
	public UserOrder getOrderDetail(long orderNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
