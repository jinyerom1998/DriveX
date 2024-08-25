package DTO;

public class CarDTO {
	private String car_no;
	private String car_name;
	private String car_drive;
	private String car_power;
	private String car_fule;
	private int car_stock;
	private int car_price;
	private String car_category;
	
	
	public CarDTO () {}
	public CarDTO(String car_no, String car_name, String car_drive, String car_power, String car_fule, int car_stock,
			int car_price, String car_category) {
		super();
		this.car_no = car_no;
		this.car_name = car_name;
		this.car_drive = car_drive;
		this.car_power = car_power;
		this.car_fule = car_fule;
		this.car_stock = car_stock;
		this.car_price = car_price;
		this.car_category = car_category;
	}
	public String getCar_no() {
		return car_no;
	}
	public String getCar_name() {
		return car_name;
	}
	public String getCar_drive() {
		return car_drive;
	}
	public String getCar_power() {
		return car_power;
	}
	public String getCar_fule() {
		return car_fule;
	}
	public int getCar_stock() {
		return car_stock;
	}
	public int getCar_price() {
		return car_price;
	}
	public String getCar_category() {
		return car_category;
	}
	
	
	
	
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public void setCar_drive(String car_drive) {
		this.car_drive = car_drive;
	}
	public void setCar_power(String car_power) {
		this.car_power = car_power;
	}
	public void setCar_fule(String car_fule) {
		this.car_fule = car_fule;
	}
	public void setCar_stock(int car_stock) {
		this.car_stock = car_stock;
	}
	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}
	public void setCar_category(String car_category) {
		this.car_category = car_category;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[차량모델번호 = ");
		builder.append(car_no);
		builder.append(" , 차랑명 = ");
		builder.append(car_name);
		builder.append(" , 구동방식 = ");
		builder.append(car_drive);
		builder.append(" , 최고출력 = ");
		builder.append(car_power);
		builder.append(" , 연비 = ");
		builder.append(car_fule);
		builder.append(" , 재고량 = ");
		builder.append(car_stock);
		builder.append(" , 차량가격 = ");
		builder.append(car_price);
		builder.append(" , 카테고리 = ");
		builder.append(car_category);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}

