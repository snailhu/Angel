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
 * ����������С����ʵ��
 *
 */
@Entity
public class UserArea {
	@Id
	@GeneratedValue
	private int id;
	
	/** С������ */
	@Column(length = 30, nullable = false)
	private String name;
	
	/**С����������������*/
	@ManyToOne
	@JoinColumn(name = "area_id")
	private SendAreaCore sendAreaCore;
	
	/**��С������Ӧ����ʹ*/
	@OneToMany(mappedBy = "userArea",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<AngelStore> angelStore;
	
	/**С����������*/
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
