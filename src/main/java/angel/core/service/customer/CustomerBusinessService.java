package angel.core.service.customer;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import angel.core.domain.common.Product;
import angel.core.domain.customer.Customer;
import angel.core.domain.customer.UserOrder;


public interface CustomerBusinessService {


	/**
	 * 获取所有商品。
	 * 
	 * */
	public Page<Product> getAllProducts(int page, int size);



	/**
	 * 根据商品编号获取商品。
	 * 
	 * */
	public Product getProductByCode(String code);
	
		
	
	/**
	 * 下订单。
	 * 
	 * */
	public UserOrder placeOrder(Map<String, Integer> items);
	

	/**
	 * 提交订单。
	 * 
	 * */
	public UserOrder submitOrder(long orderNo, MultipartFile sign);

	/**
	 * 取消订单。
	 * 
	 * */
	public void cancelOrder(long orderNo);

	/**
	 * 获取订单详情。
	 * 
	 * */
	public UserOrder getOrder(long orderNo);

	/**
	 * 获取全部订单。
	 * 
	 * */
	public Page<UserOrder> getOrders(Customer customer,int page, int size);



}
