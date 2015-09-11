package angel.core.service.customer;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import angel.core.domain.common.Product;
import angel.core.domain.customer.Customer;
import angel.core.domain.customer.UserOrder;


public interface CustomerBusinessService {


	/**
	 * ��ȡ������Ʒ��
	 * 
	 * */
	public Page<Product> getAllProducts(int page, int size);



	/**
	 * ������Ʒ��Ż�ȡ��Ʒ��
	 * 
	 * */
	public Product getProductByCode(String code);
	
		
	
	/**
	 * �¶�����
	 * 
	 * */
	public UserOrder placeOrder(Map<String, Integer> items);
	

	/**
	 * �ύ������
	 * 
	 * */
	public UserOrder submitOrder(long orderNo, MultipartFile sign);

	/**
	 * ȡ��������
	 * 
	 * */
	public void cancelOrder(long orderNo);

	/**
	 * ��ȡ�������顣
	 * 
	 * */
	public UserOrder getOrder(long orderNo);

	/**
	 * ��ȡȫ��������
	 * 
	 * */
	public Page<UserOrder> getOrders(Customer customer,int page, int size);



}
