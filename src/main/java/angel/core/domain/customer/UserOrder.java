package angel.core.domain.customer;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import angel.core.domain.angel.AngelStore;


@Entity
public class UserOrder {
	@Id
	@GeneratedValue
	private Long id;

	/** �������,ʮ��λ,����Ϊ��ʱ��+5λ�����̱��+5λ��������ˮ�ţ����ӣ�201407080000100005 */
	@Column(nullable = false, unique = true)
	private Long orderNum;

	/** ���������� */
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/** ������ʹ�ŵ� */
	@ManyToOne(optional = false)
	@JoinColumn(name = "angelstore_id")
	private AngelStore angelStore;

	/** ������������ʱ�� */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createDateDetail = new Date();
	
	/** ��������ʱ�������� */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createDateYMD = new Date();

	/** �������ʱ�䡣 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;

	/** ����״̬ */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserOrderState state;

	/** ��Ʒ�ܽ�� */
	@Column(nullable = false)
	private Float productTotalPrice = 0f;

	/** �����ܽ�� */
	@Column(nullable = false)
	private Float totalPrice = 0f;

	/** Ӧ����(ʵ����Ҫ֧���ķ���) */
	@Column(nullable = false)
	private Float payablefee = 0f;

	/** ������ */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Set<UserOrderItems> items;
	
	/**�������������*/
	private int year;
	
	/**�����������·�*/
	private int month;
	
	/**��������������*/
	private int day;

	/** ������ǩ�� */
	@Column(length = 200)
	private String signPic;

	/** ��Ʒ������� */
	private Integer product;

	/** ����̬�� */
	private Integer attitude;

	/** ���� */
	@Column(length = 50)
	private String words;

	/** ��ע */
	@Column(length = 50)
	private String note;

	/** ��Ʒ */
	@Column(length = 300)
	private String rewards;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AngelStore getAngelStore() {
		return angelStore;
	}

	public void setAngelStore(AngelStore angelStore) {
		this.angelStore = angelStore;
	}

	public Date getCreateDateDetail() {
		return createDateDetail;
	}

	public void setCreateDateDetail(Date createDateDetail) {
		this.createDateDetail = createDateDetail;
	}

	public Date getCreateDateYMD() {
		return createDateYMD;
	}

	public void setCreateDateYMD(Date createDateYMD) {
		this.createDateYMD = createDateYMD;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}


	public Float getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(Float productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getPayablefee() {
		return payablefee;
	}

	public void setPayablefee(Float payablefee) {
		this.payablefee = payablefee;
	}

	public Set<UserOrderItems> getItems() {
		return items;
	}

	public void setItems(Set<UserOrderItems> items) {
		this.items = items;
	}

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public Integer getAttitude() {
		return attitude;
	}

	public void setAttitude(Integer attitude) {
		this.attitude = attitude;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public UserOrderState getState() {
		return state;
	}

	public void setState(UserOrderState state) {
		this.state = state;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
}
