package angel.core.domain.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import angel.core.domain.User;
import angel.core.domain.areaCore.SendAreaCore;

/**
 * 
 * 消费者
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	/**消费者的真实姓名*/
	@Column(length = 30, nullable = false)
	private String realName;
	
	/**对应的User*/
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private User customer_User;
	
	/**所在的小区*/
	/**小区所属的配送中心*/
	@ManyToOne
	@JoinColumn(name = "userAreaId")
	private UserArea userArea;
	
	/**消费者地址*/
	@Column(length = 30, nullable = false)
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public User getCustomer_User() {
		return customer_User;
	}

	public void setCustomer_User(User customer_User) {
		this.customer_User = customer_User;
	}

	public UserArea getUserArea() {
		return userArea;
	}

	public void setUserArea(UserArea userArea) {
		this.userArea = userArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
