package angel.core.domain.customer;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.areaCore.SendAreaCore;


/**
 * 
 * 消费者所在小区的实体
 *
 */
@Entity
public class UserArea {
	@Id
	@GeneratedValue
	private int id;
	
	/** 小区名称 */
	@Column(length = 30, nullable = false)
	private String name;
	
	/**小区所属的配送中心*/
	@ManyToOne
	@JoinColumn(name = "area_id")
	private SendAreaCore sendAreaCore;
	
	/**此小区所对应的天使*/
	@OneToMany(mappedBy = "userArea",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<AngelStore> angelStore;
	
	/**小区的消费者*/
	@OneToMany
	@JoinColumn(name = "userAreaId")
	private Set<Customer> customers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SendAreaCore getSendAreaCore() {
		return sendAreaCore;
	}

	public void setSendAreaCore(SendAreaCore sendAreaCore) {
		this.sendAreaCore = sendAreaCore;
	}

	
	public Set<AngelStore> getAngelStore() {
		return angelStore;
	}

	public void setAngelStore(Set<AngelStore> angelStore) {
		this.angelStore = angelStore;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	
	
}
