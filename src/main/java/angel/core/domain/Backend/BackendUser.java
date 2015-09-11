package angel.core.domain.Backend;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import angel.core.domain.User;

@Entity
public class BackendUser {
	@Id
	@GeneratedValue
	private int id;
	
	/**后台管理员的真实姓名*/
	@Column(length = 30, nullable = false)
	private String realName;
	
	/**对应的User*/
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private User backend_User;

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

	public User getBackend_User() {
		return backend_User;
	}

	public void setBackend_User(User backend_User) {
		this.backend_User = backend_User;
	}

	
}
