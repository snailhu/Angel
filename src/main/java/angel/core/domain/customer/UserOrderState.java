package angel.core.domain.customer;


public enum UserOrderState {
	/** δ�ύ */
	NOTSUBMIT {
		@Override
		public String getName() {
			return "δ�ύ";
		}
	},

	/** δ���� */
	NOTHANDLE {
		@Override
		public String getName() {
			return "δ����";
		}
	},
	/** δ���� */
	NOTSEND {
		@Override
		public String getName() {
			return "δ����";
		}
	},
	/** ������� */
	FINISHHANDLE {
		@Override
		public String getName() {
			return "�������";
		}
	},

	/** ��ȡ�� */
	CANCELED {
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "��ȡ��";
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
			throw new IllegalArgumentException("UserOrderState����ʧ�ܡ�������ƥ�䡣");
		}		
	}
}
