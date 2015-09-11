package angel.core.domain.common;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import angel.core.domain.angel.AngelStore;


/**
 * 
 * @author Administrator
 *�ֿ�ʵ��
 */
public class Repertory {
	
	/** �۸� */
	@Column(nullable = false)
	private Float price;
	


	/** ����� */
	@Column(nullable = false)
	private Integer amounts;

	/** ���� */
	@Column(nullable = false)
	private Integer salesVol;
	
	/** ��������ʹ */
	@ManyToOne
	@JoinColumn(name = "dealer_id")
	private AngelStore angelStore;

	/** ��������Ʒ��Ϣ */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
