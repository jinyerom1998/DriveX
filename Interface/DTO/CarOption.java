package DTO;

public class CarOption 
{
	int opno;
	String optionName;
	int optionPrice;
	
	public CarOption() 
	{
		
	}

	public CarOption(int opno, String optionName, int optionPrice) {
		super();
		this.opno = opno;
		this.optionName = optionName;
		this.optionPrice = optionPrice;
	}

	public int getOpno() {
		return opno;
	}

	public void setOpno(int opno) {
		this.opno = opno;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	
	
}
