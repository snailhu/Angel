package angel.core.domain.customer;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import angel.core.domain.common.Product;

@Embeddable
public class UserOrderItemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 关联的订单 */
	@ManyToOne
	@JoinColumn(name = "order_id")
	private UserOrder order;

	/** 关联的商品 */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public UserOrderItemPK() {
	}

	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserOrderItemPK other = (UserOrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
}
