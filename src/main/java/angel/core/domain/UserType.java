package angel.core.domain;



public enum UserType {

	/** ҵ��Ա */
	AGENT {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "ҵ��Ա";
		}
		
		},
	/** ��ʹ */
	ANGEL {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "��ʹ";
		}

		
		},
	/** ������ */
	CUSTOMER_USER{

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "������";
		} 	 	
		
		},
	/** ��̨������ */
	BACKEND_USER{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "������";
	} 	 	
	
	};
		
	public abstract String getName();
}
