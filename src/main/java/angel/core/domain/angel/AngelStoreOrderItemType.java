package angel.core.domain.angel;

public enum AngelStoreOrderItemType {


	/** 销售订单 */
	NO,

	/** 折扣订单 */
	DO;

	public static AngelStoreOrderItemType parseAngelStoreOrderItemType(String type) {

		if (type.equals("NO")) {
			return NO;
		} else if (type.equals("DO")) {
			return DO;
		} else {
			throw new IllegalArgumentException("parseDealerOrderItemType参数解析错误。");
		}
	}

}
