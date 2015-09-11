package angel.core.domain.common;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import angel.core.domain.angel.AngelStore;


/**
 * 
 * @author Administrator
 *仓库实体
 */
public class Repertory {
	
	/** 价格 */
	@Column(nullable = false)
	private Float price;
	


	/** 库存量 */
	@Column(nullable = false)
	private Integer amounts;

	/** 销量 */
	@Column(nullable = false)
	private Integer salesVol;
	
	/** 关联的天使 */
	@ManyToOne
	@JoinColumn(name = "dealer_id")
	private AngelStore angelStore;

	/** 关联的商品信息 */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
