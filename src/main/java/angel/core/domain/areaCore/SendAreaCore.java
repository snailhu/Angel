package angel.core.domain.areaCore;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import angel.core.domain.User;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;
import angel.core.domain.common.Product;
import angel.core.domain.customer.Customer;
import angel.core.domain.customer.UserArea;



/**
 * ��������ʵ�塣
 * 
 **/
@Entity
@Table(name = "send_area_core")
public class SendAreaCore {
	
	/** ID */
	@Id
	@GeneratedValue
	private Integer id;
	
	
	/**Ŀǰ�����۶�*/
	@Column(nullable = false)
	private Float price;
		
	
	/** ������������ */
	@Column(length = 30, nullable = false)
	private String sendAreaName;
	
	
	/** ��������Ʒ��Ϣ */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	/**���������ĵ��û�*/

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private User AreaCoreUser;
	
	/** �������������͵�С��*/
	@OneToMany
	@JoinColumn(name = "area_id")
	private Set<UserArea> userAreas;
	
	
	/** ��������������������·*/
	@OneToMany
	@JoinColumn(name = "areaCore_id")
	private Set<Line> lines;
		
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSendAreaName() {
		return sendAreaName;
	}


	public void setSendAreaName(String sendAreaName) {
		this.sendAreaName = sendAreaName;
	}


	public Set<UserArea> getUserAreas() {
		return userAreas;
	}


	public void setUserAreas(Set<UserArea> userAreas) {
		this.userAreas = userAreas;
	}

	public Set<Line> getLines() {
		return lines;
	}


	public void setLines(Set<Line> lines) {
		this.lines = lines;
	}
	
	
	
}
