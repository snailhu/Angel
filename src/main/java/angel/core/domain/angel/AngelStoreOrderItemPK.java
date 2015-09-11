package angel.core.domain.angel;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class AngelStoreOrderItemPK implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 关联的订单 */
	@ManyToOne
	@JoinColumn(name = "order_id")
	private AngelStoreOrder order;


	/** 订单项行号 */
	private Integer lineNo;

	public AngelStoreOrderItemPK() {
	}

	public AngelStoreOrder getOrder() {
		return order;
	}

	public void setOrder(AngelStoreOrder order) {
		this.order = order;
	}

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineNo == null) ? 0 : lineNo.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		AngelStoreOrderItemPK other = (AngelStoreOrderItemPK) obj;
		if (lineNo == null) {
			if (other.lineNo != null)
				return false;
		} else if (!lineNo.equals(other.lineNo))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	
	
}
