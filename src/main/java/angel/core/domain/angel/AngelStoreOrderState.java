package angel.core.domain.angel;

import org.springframework.util.Assert;


public enum AngelStoreOrderState {

	/** 未提交 */
	NOTSUBMIT {
		@Override
		public String getName() {
			return "未提交";
		}
	},

	/** 待配送 */
	NOTHANDLE {
		@Override
		public String getName() {
			return "待配送";
		}
	},
	/** 配送完成 */
	FINISHHANDLE {
		@Override
		public String getName() {
			return "配送完成";
		}
	},

	/** 已取消 */
	CANCELED {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "已取消";
		}
	};

	public abstract String getName();

	public static AngelStoreOrderState parseStoreOrderState(String state) {
		Assert.hasLength(state, "参数不能为空。");
		if (state.equals("NOTHANDLE")) {
			return AngelStoreOrderState.NOTHANDLE;
		}  else if (state.equals("FINISHHANDLE")) {
			return AngelStoreOrderState.FINISHHANDLE;
		} else if (state.equals("NOTSUBMIT")) {
			return AngelStoreOrderState.NOTSUBMIT;
		} else if (state.equals("CANCELED")) {
			return AngelStoreOrderState.CANCELED;
		} else {
			throw new IllegalArgumentException("StoreOrderState解析失败。参数不匹配。");
		}
	};
	
}
