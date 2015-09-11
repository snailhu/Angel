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

	/** 订单编号,十八位,定义为：时间+5位经销商编号+5位经销商流水号，例子：201407080000100005 */
	@Column(nullable = false, unique = true)
	private Long orderNum;

	/** 所属消费者 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/** 所属天使门店 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "angelstore_id")
	private AngelStore angelStore;

	/** 订单创建具体时间 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createDateDetail = new Date();
	
	/** 订单创建时间年月日 */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createDateYMD = new Date();

	/** 订单完成时间。 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;

	/** 订单状态 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserOrderState state;

	/** 商品总金额 */
	@Column(nullable = false)
	private Float productTotalPrice = 0f;

	/** 订单总金额 */
	@Column(nullable = false)
	private Float totalPrice = 0f;

	/** 应付款(实际需要支付的费用) */
	@Column(nullable = false)
	private Float payablefee = 0f;

	/** 订单项 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Set<UserOrderItems> items;
	
	/**订单创建的年份*/
	private int year;
	
	/**订单创建的月份*/
	private int month;
	
	/**订单创建的日期*/
	private int day;

	/** 消费者签字 */
	@Column(length = 200)
	private String signPic;

	/** 商品描述相符 */
	private Integer product;

	/** 服务态度 */
	private Integer attitude;

	/** 留言 */
	@Column(length = 50)
	private String words;

	/** 备注 */
	@Column(length = 50)
	private String note;

	/** 赠品 */
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
