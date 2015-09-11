package angel.core.domain.angel;

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

import angel.core.domain.areaCore.SendAreaCore;

/**
 * 
 * @author Administrator
 *
 */
@Entity
public class AngelStoreOrder {
	
	@Id
	@GeneratedValue
	private Long id;

	/** �����ţ����ӣ�2014070900001005 */
	@Column(nullable = false, unique = true)
	private Long orderNum;

	/** ��������������� */
	@ManyToOne(optional = false)
	@JoinColumn(name = "areaCore_id")
	private SendAreaCore sendAreaCore;

	/** ������ʹ�ŵ� */
	@ManyToOne(optional = false)
	@JoinColumn(name = "angelstore_id")
	private AngelStore angelStore;


	/** ������������ʱ�� */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createDateDetail = new Date();
	
	/** �������������� */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createDateYMD = new Date();

	/** �������ʱ�䡣 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;

	/** ����״̬ */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AngelStoreOrderState state;

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
	private Set<AngelStoreOrderItems> items;
	
	/**�������������*/
	private int year;
	
	/**�����������·�*/
	private int month;
	
	/**��������������*/
	private int day;
	
		
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

	/** ����̬�� */
	private Integer manner;

	/** ���� */
	@Column(length = 50)
	private String words;

	/** ��ע */
	@Column(length = 50)
	private String note;

	/** ��Ʒ */
	@Column(length = 300)
	private String rewards;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
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

	public AngelStoreOrderState getState() {
		return state;
	}

	public void setState(AngelStoreOrderState state) {
		this.state = state;
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

	public Set<AngelStoreOrderItems> getItems() {
		return items;
	}

	public void setItems(Set<AngelStoreOrderItems> items) {
		this.items = items;
	}

	public Integer getManner() {
		return manner;
	}

	public void setManner(Integer manner) {
		this.manner = manner;
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
	
	
	
}
