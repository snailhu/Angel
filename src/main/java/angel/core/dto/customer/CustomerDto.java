package angel.core.dto.customer;

import angel.core.domain.customer.Customer;
import angel.core.pojo2json.BaseDTO;

public class CustomerDto extends BaseDTO<Customer, CustomerDto> {
	
	/**用户名*/
	private String userName;
	
	/**电话号码*/
	private String phoneNum;
	
	/**地址*/
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
