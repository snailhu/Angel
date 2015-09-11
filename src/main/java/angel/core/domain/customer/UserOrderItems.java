package angel.core.domain.customer;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class UserOrderItems {

	/** 联合主键 */
	@EmbeddedId
	private UserOrderItemPK pk;

	/** 购买数量 */
	@Column(nullable = false)
	private Integer amount;

	/** 单价 */
	@Column(nullable = false)
	private Float unitPrice;

	/** 折扣信息描述 */
	@Column(length = 180)
	private String discountDisc;

	public UserOrderItemPK getPk() {
		return pk;
	}

	public void setPk(UserOrderItemPK pk) {
		this.pk = pk;
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

	public String getDiscountDisc() {
		return discountDisc;
	}

	public void setDiscountDisc(String discountDisc) {
		this.discountDisc = discountDisc;
	}
	
	
}
