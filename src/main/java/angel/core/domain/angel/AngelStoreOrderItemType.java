package angel.core.domain.angel;

public enum AngelStoreOrderItemType {


	/** ���۶��� */
	NO,

	/** �ۿ۶��� */
	DO;

	public static AngelStoreOrderItemType parseAngelStoreOrderItemType(String type) {

		if (type.equals("NO")) {
			return NO;
		} else if (type.equals("DO")) {
			return DO;
		} else {
			throw new IllegalArgumentException("parseDealerOrderItemType������������");
		}
	}

}
