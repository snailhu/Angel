package angel.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import angel.core.domain.Backend.BackendUser;
import angel.core.domain.angel.AngelStore;
import angel.core.domain.areaCore.SendAreaCore;
import angel.core.domain.customer.Customer;

@Entity
public class User {

	/**ID*/
	@Id
	@GeneratedValue
	private int id;
	/**�û��˺�*/
	@Column(length = 20, nullable = false, unique = true)
	private String account;
	
	/**��ֵ	*/
	@Column(length = 20, nullable = false, unique = true)
	private String salt;
	
	/**�û�����*/
	@Column(length = 200, nullable = false)
	private String password;
		
	/**����ͷ��*/	
	private String imgUrl;
	
	/** �˻��Ƿ����� */
	@Column(nullable = false)
	private Boolean enabled = true;

	/** �˻��Ƿ�δ���� */
	@Column(nullable = false)
	private Boolean accountNonExpired = true;

	/** ֤���Ƿ�δ���� */
	@Column(nullable = false)
	private Boolean credentialsNonExpired = true;

	/** �˻��󶨵��ֻ��� */
	@Column(unique = true, length = 20)
	private String phone;

	/** �˻��Ƿ�δ������ */
	@Column(nullable = false)
	private Boolean accountNonLocked = true;
	
	/**���������û�*/
	@OneToOne(mappedBy ="AreaCoreUser")
	private SendAreaCore sendAreaCore;

	/**��̨����Ա*/
	@OneToOne(mappedBy="backend_User")
	private BackendUser backendUser;
	
	/**������*/
	@OneToOne(mappedBy ="customer_User")
	private Customer customerUser;
	
	/**��ʹ*/
	@OneToOne(mappedBy ="angel_User")
	private AngelStore angelStore;
	
//	/** �û����� */
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false, length = 20)
//	private UserType userType;
			
	public String getSalt() {
		return salt;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public UserType getUserType() {
//		return userType;
//	}
//
//	public void setUserType(UserType userType) {
//		this.userType = userType;
//	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	
	public SendAreaCore getSendAreaCore() {
		return sendAreaCore;
	}

	public void setSendAreaCore(SendAreaCore sendAreaCore) {
		this.sendAreaCore = sendAreaCore;
	}

	public AngelStore getAngelStore() {
		return angelStore;
	}

	public void setAngelStore(AngelStore angelStore) {
		this.angelStore = angelStore;
	}

	public BackendUser getBackendUser() {
		return backendUser;
	}

	public void setBackendUser(BackendUser backendUser) {
		this.backendUser = backendUser;
	}

	public Customer getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(Customer customerUser) {
		this.customerUser = customerUser;
	}


	
}
