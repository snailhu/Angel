package angel.core.dto.customer;

import angel.core.domain.customer.Customer;
import angel.core.pojo2json.BaseDTO;

public class CustomerDto extends BaseDTO<Customer, CustomerDto> {
	
	/**�û���*/
	private String userName;
	
	/**�绰����*/
	private String phoneNum;
	
	/**��ַ*/
	private String address;

	@Override
	public CustomerDto convert(Customer domain) {
		CustomerDto customerDto= new CustomerDto();
		customerDto.setAddress(domain.getAddress());
		customerDto.setPhoneNum(domain.getCustomer_User().getPhone());
		customerDto.setUserName(domain.getRealName());
		return customerDto;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}




	
	
}
