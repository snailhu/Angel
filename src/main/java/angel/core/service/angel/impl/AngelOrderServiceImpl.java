package angel.core.service.angel.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import angel.core.Exception.RecordNotFoundException;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.angel.AngelStoreOrderItemPK;
import angel.core.domain.angel.AngelStoreOrderItems;
import angel.core.domain.angel.AngelStoreOrderState;
import angel.core.domain.areaCore.SendAreaCore;
import angel.core.domain.common.Product;
import angel.core.repository.angel.AngelStoreOrderItemsRepository;
import angel.core.repository.angel.AngelStoreOrderRepository;
import angel.core.repository.common.ProductRepository;
import angel.core.repository.customer.UserOrderRepository;
import angel.core.service.angel.AngelOrderService;
import angel.core.util.GenerateOrderNum;

@Service
@Transactional
public class AngelOrderServiceImpl implements AngelOrderService {
	@Resource
	private UserOrderRepository userOrderRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private AngelStoreOrderItemsRepository angelStoreOrderItemsRepository;
	@Resource
	private AngelStoreOrderRepository angelStoreOrderRepository;
	
	private Pageable getPageable(int page, int size) {
		if (page <= 0)
			page = 1;
		if (size <= 0) {
			size = 20;
		}
		return new PageRequest(page - 1, size);
	}	

	@Override
	public AngelStoreOrder placeAnOrder(AngelStore store,
			Map<String, Integer> items) {
		SendAreaCore sendAreaCore= store.getUserArea().getSendAreaCore();
		AngelStoreOrder order= new AngelStoreOrder();
		order.setAngelStore(store);
		order.setOrderNum(GenerateOrderNum.generateOrderNum());
		order.setSendAreaCore(sendAreaCore);		
		Set<AngelStoreOrderItems> setItems = new HashSet<AngelStoreOrderItems>();
		order.setItems(setItems);
		order.setState(AngelStoreOrderState.NOTSUBMIT);
		Float orderTotalPrice=0f;
		
		for (Entry<String, Integer> entry : items.entrySet()) {
			String code = entry.getKey();
			Product product = productRepository.findOne(code);
			
			if (product == null) {
				throw new RecordNotFoundException();
			}
			AngelStoreOrderItems angelStoreOrderItems=new AngelStoreOrderItems();
			angelStoreOrderItems.setProduct(product);
			angelStoreOrderItems.setUnitPrice(product.getPrice());
			angelStoreOrderItems.setTotalPrice(product.getPrice()*entry.getValue());
			angelStoreOrderItems.setAmount(entry.getValue());
			AngelStoreOrderItemPK angelStoreOrderItemPK=new AngelStoreOrderItemPK();
			angelStoreOrderItemPK.setOrder(order);
			angelStoreOrderItems.setPk(angelStoreOrderItemPK);
			angelStoreOrderItemsRepository.save(angelStoreOrderItems);
			setItems.add(angelStoreOrderItems);		
			orderTotalPrice+=(product.getPrice()*entry.getValue());
		}
		order.setItems(setItems);
		Date date =new Date();
		order.setCreateDateDetail(date);
		order.setCreateDateYMD(date);
		order.setProductTotalPrice(orderTotalPrice);
		order.setMonth(date.getMonth());
		order.setYear(date.getYear());
		angelStoreOrderRepository.save(order);
		return order;
	}

	@Override
	public void submitAngelOrder(Long orderNum) {
		AngelStoreOrder angelStoreOrder=angelStoreOrderRepository.findByOrderNum(orderNum);
		if(angelStoreOrder==null)throw new RecordNotFoundException("该订单不存在");
		angelStoreOrder.setState(AngelStoreOrderState.NOTHANDLE);
		angelStoreOrderRepository.save(angelStoreOrder);					
	}

	@Override
	public Page<AngelStoreOrder> getAngelOrdersByTime(AngelStore store, int page, int size, Date date) {		
		Page<AngelStoreOrder> angelStoreOrders=angelStoreOrderRepository.findByAngelStoreAndDate(store, date, getPageable(page,size));
		if(angelStoreOrders==null)throw new RecordNotFoundException("没有找到改时间内的订单");
		else{
			return angelStoreOrders;
		}
	}


	@Override
	public Float getAngelOrderTotalMoney(AngelStore store) {
		List<AngelStoreOrder> angelStoreOrders=angelStoreOrderRepository.findByStore(store);
		if(angelStoreOrders.size()<=0)throw new RecordNotFoundException("目前还没有订单");
		Float totalMoney=0f;
		for(AngelStoreOrder aso:angelStoreOrders){
			totalMoney+=aso.getTotalPrice();
		}
		return totalMoney;
	}

}
