package angel.core.domain.angel;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import angel.core.domain.common.Product;
@Entity
public class AngelStoreOrderItems {
	
	/** �������� */
	@EmbeddedId
	private AngelStoreOrderItemPK pk;

	/** ��������Ʒ */
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_code")
	private Product product;

	/** ���� */
	private Float unitPrice;

	/** ���� */
	private Integer amount;

	/** ��λ */
	@Column(length = 20)
	private String unitMeas;

	/** �ۿ۰ٷֱ� */
	private Float discount;

	/** ���ֽ�� */
	private Integer points;
	
	/**�ܽ��*/
	private Float totalPrice;

	/** �������� */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private AngelStoreOrderItemType type;

	public AngelStoreOrderItemPK getPk() {
		return pk;
	}

	public void setPk(AngelStoreOrderItemPK pk) {
		this.pk = pk;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUnitMeas() {
		return unitMeas;
	}

	public void setUnitMeas(String unitMeas) {
		this.unitMeas = unitMeas;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public AngelStoreOrderItemType getType() {
		return type;
	}

	public void setType(AngelStoreOrderItemType type) {
		this.type = type;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
