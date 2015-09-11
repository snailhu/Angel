package angel.core.dto.customer;

import java.util.List;

import angel.core.domain.customer.UserOrder;
import angel.core.pojo2json.BaseDTO;
import angel.core.pojo2json.DTOContext;

public class UserOrderDto extends BaseDTO<UserOrder, UserOrderDto> {

	/**订单号*/
	private Long orderNum;
	
	/**订单项*/
	private List<UserOrderItemDto> userOrderItemsDto;
	
	/**订单用户*/
	private CustomerDto customerDto;
	
	/**商品的总数*/
	private int Toalnum;
	
	/**商品的总金额*/
	private float TotalPrice;
	
	
	@Override
	public UserOrderDto convert(UserOrder domain) {
		UserOrderDto userOrderDto =new UserOrderDto();
		userOrderDto.setOrderNum(domain.getOrderNum());
		userOrderDto.setTotalPrice(domain.getTotalPrice());
		userOrderDto.setUserOrderItemsDto(DTOContext.getConverter(UserOrderItemDto.class).convert(domain.getItems()));		
		userOrderDto.setToalnum(domain.getItems().size());
		userOrderDto.setCustomerDto(DTOContext.getConverter(CustomerDto.class).convert(domain.getCustomer()));
		return userOrderDto;
	}
	
	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	
	public List<UserOrderItemDto> getUserOrderItemsDto() {
		return userOrderItemsDto;
	}

	public void setUserOrderItemsDto(List<UserOrderItemDto> userOrderItemsDto) {
		this.userOrderItemsDto = userOrderItemsDto;
	}

	
	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public int getToalnum() {
		return Toalnum;
	}

	public void setToalnum(int toalnum) {
		Toalnum = toalnum;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}




	
	
}
