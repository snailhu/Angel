package angel.core.domain.angel;

import org.springframework.util.Assert;


public enum AngelStoreOrderState {

	/** δ�ύ */
	NOTSUBMIT {
		@Override
		public String getName() {
			return "δ�ύ";
		}
	},

	/** ������ */
	NOTHANDLE {
		@Override
		public String getName() {
			return "������";
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

	public static AngelStoreOrderState parseStoreOrderState(String state) {
		Assert.hasLength(state, "��������Ϊ�ա�");
		if (state.equals("NOTHANDLE")) {
			return AngelStoreOrderState.NOTHANDLE;
		}  else if (state.equals("FINISHHANDLE")) {
			return AngelStoreOrderState.FINISHHANDLE;
		} else if (state.equals("NOTSUBMIT")) {
			return AngelStoreOrderState.NOTSUBMIT;
		} else if (state.equals("CANCELED")) {
			return AngelStoreOrderState.CANCELED;
		} else {
			throw new IllegalArgumentException("StoreOrderState����ʧ�ܡ�������ƥ�䡣");
		}
	};
	
}
