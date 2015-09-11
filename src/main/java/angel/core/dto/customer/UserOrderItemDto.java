package angel.core.dto.customer;

import javax.persistence.Column;

import angel.core.domain.customer.UserOrderItems;
import angel.core.pojo2json.BaseDTO;

public class UserOrderItemDto extends BaseDTO<UserOrderItems, UserOrderItemDto>{

	/**商品名*/
	private String productName;
	
	/** 购买数量 */
	@Column(nullable = false)
	private Integer amount;

	/** 单价 */
	@Column(nullable = false)
	private Float unitPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public UserOrderItemDto convert(UserOrderItems domain) {
		UserOrderItemDto userOrderItemDto=new UserOrderItemDto();
		userOrderItemDto.setAmount(domain.getAmount());
		userOrderItemDto.setProductName(domain.getPk().getProduct().getProductName());
		userOrderItemDto.setUnitPrice(domain.getUnitPrice());
		return userOrderItemDto;
	}
	
	

}
