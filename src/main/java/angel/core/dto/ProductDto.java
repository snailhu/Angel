package angel.core.dto;

public class ProductDto {

	/**商品名称*/
	private String productName;
	
	/**订购商品数量*/
	private int num;
	
	/**商品的单价*/	
	private float money;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	
}
