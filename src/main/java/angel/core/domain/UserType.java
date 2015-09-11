package angel.core.domain;



public enum UserType {

	/** 业务员 */
	AGENT {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "业务员";
		}
		
		},
	/** 天使 */
	ANGEL {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "天使";
		}

		
		},
	/** 消费者 */
	CUSTOMER_USER{

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "消费者";
		} 	 	
		
		},
	/** 后台管理者 */
	BACKEND_USER{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "管理者";
	} 	 	
	
	};
		
	public abstract String getName();
}
