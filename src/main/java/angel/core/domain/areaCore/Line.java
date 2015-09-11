package angel.core.domain.areaCore;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Line {

	/*
	 * 每个业务员对应的6条路线代号。
	 */
	public static final int CODE_A1 = 1;
	public static final int CODE_A2 = 2;
	public static final int CODE_A3 = 3;
	public static final int CODE_A4 = 4;
	public static final int CODE_A5 = 5;
	public static final int CODE_A6 = 6;


	/** ID */
	@Id
	@GeneratedValue
	private Long id;

	/** 路线代号，生成之后不可修改。 */
	@Column(updatable = false, nullable = false)
	private Integer code;

	/** 此路线所属的区域管理中心 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "areaCore_id")
	private SendAreaCore sendAreaCore;

	/** 此路线包括的节点。 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "line_id")
	@OrderBy("pk.serialNum ASC")
	private List<LineNode> nodes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public SendAreaCore getSendAreaCore() {
		return sendAreaCore;
	}

	public void setSendAreaCore(SendAreaCore sendAreaCore) {
		this.sendAreaCore = sendAreaCore;
	}

	public List<LineNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<LineNode> nodes) {
		this.nodes = nodes;
	}
	
	
}
