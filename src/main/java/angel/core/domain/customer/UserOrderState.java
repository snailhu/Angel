package angel.core.domain.customer;


public enum UserOrderState {
	/** 未提交 */
	NOTSUBMIT {
		@Override
		public String getName() {
			return "未提交";
		}
	},

	/** 未接受 */
	NOTHANDLE {
		@Override
		public String getName() {
			return "未接受";
		}
	},
	/** 未配送 */
	NOTSEND {
		@Override
		public String getName() {
			return "未配送";
		}
	},
	/** 处理完成 */
	FINISHHANDLE {
		@Override
		public String getName() {
			return "处理完成";
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


	
	public static UserOrderState parseUserOrderState(String state){
		if (state.equals("NOTHANDLE")) {
			return UserOrderState.NOTHANDLE;
		} else if (state.equals("NOTSEND")) {
			return UserOrderState.NOTSEND;
		} else if (state.equals("FINISHHANDLE")) {
			return UserOrderState.FINISHHANDLE;
		} else if (state.equals("NOTSUBMIT")) {
			return UserOrderState.NOTSUBMIT;
		} else if (state.equals("CANCELED")) {
			return UserOrderState.CANCELED;
		} else {
			throw new IllegalArgumentException("UserOrderState解析失败。参数不匹配。");
		}		
	}
}
