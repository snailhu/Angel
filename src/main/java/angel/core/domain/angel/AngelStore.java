package angel.core.domain.angel;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import angel.core.domain.User;
import angel.core.domain.customer.UserArea;


/**
 * 
 * ��ʹ�ŵ�ʵ��
 *
 */
@Entity
public class AngelStore {

	@Id
	@GeneratedValue
	private int id;
	
	/**��ʹ��ע����*/
	@Column(unique=true,length=30,nullable = false)
	private String registration_Code;
	
	/**��ʹ����*/
	@Column(length=30,nullable = false)
	private String name;
	
	/**��Ӧ��User*/
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private User angel_User;
	
	/**����ʹ���ڵ�С��*/
	@ManyToOne(optional = false)
	@JoinColumn(name = "area_id")
	private UserArea userArea;
	
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

	public User getAngel_User() {
		return angel_User;
	}

	public void setAngel_User(User angel_User) {
		this.angel_User = angel_User;
	}

	public UserArea getUserArea() {
		return userArea;
	}

	public void setUserArea(UserArea userArea) {
		this.userArea = userArea;
	}

	public String getRegistration_Code() {
		return registration_Code;
	}

	public void setRegistration_Code(String registration_Code) {
		this.registration_Code = registration_Code;
	}

			
}
