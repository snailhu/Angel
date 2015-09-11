package angel.core.domain.areaCore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * 
 * 路线节点
 * 
 */
@Entity
public class LineNode {

	/** ID */
	@EmbeddedId
	private LineNodePK pk;

	/** 节点名称 */
	@Column(length = 30, nullable = false)
	private String name;

	public LineNodePK getPk() {
		return pk;
	}

	public void setPk(LineNodePK pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
