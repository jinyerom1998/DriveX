package DTO;

public class OptionDTO {
	int option_no;
	String option_Name;
	int option_Price;
	
	public OptionDTO() 	{}

	public OptionDTO(int option_no, String option_Name, int option_Price) {
		super();
		this.option_no = option_no;
		this.option_Name = option_Name;
		this.option_Price = option_Price;
	}

	public int getOption_no() {
		return option_no;
	}

	public String getOption_Name() {
		return option_Name;
	}

	public int getOption_Price() {
		return option_Price;
	}

	public void setOption_no(int option_no) {
		this.option_no = option_no;
	}

	public void setOption_Name(String option_Name) {
		this.option_Name = option_Name;
	}

	public void setOption_Price(int option_Price) {
		this.option_Price = option_Price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 옵션번호 = ");
		builder.append(option_no);
		builder.append(", 옵션명 = ");
		builder.append(option_Name);
		builder.append(", 가격 = ");
		builder.append(option_Price);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
