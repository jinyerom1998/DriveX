package DTO;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDTO {

	private int purchase_no;
	private int purchase_member_No;
	private boolean purchase_sunRoof;
	private boolean purchase_seat;
	private boolean purchase_around_View;
	private String purchase_color;
	private String purchase_date;
	private int purchase_price;
	private int purchase_dealer_No;
	private String purchase_car_No;

	public PurchaseDTO () {}
	public PurchaseDTO(int purchase_no, int purchase_member_No, boolean purchase_sunRoof, boolean purchase_seat,
			boolean purchase_around_View, String purchase_color, String purchase_date, int purchase_price,
			int purchase_dealer_No, String purchase_car_No) {
		super();
		this.purchase_no = purchase_no;
		this.purchase_member_No = purchase_member_No;
		this.purchase_sunRoof = purchase_sunRoof;
		this.purchase_seat = purchase_seat;
		this.purchase_around_View = purchase_around_View;
		this.purchase_color = purchase_color;
		this.purchase_date = purchase_date;
		this.purchase_price = purchase_price;
		this.purchase_dealer_No = purchase_dealer_No;
		this.purchase_car_No = purchase_car_No;
	}
	public int getPurchase_no() {
		return purchase_no;
	}
	public int getPurchase_member_No() {
		return purchase_member_No;
	}
	public boolean isPurchase_sunRoof() {
		return purchase_sunRoof;
	}
	public boolean isPurchase_seat() {
		return purchase_seat;
	}
	public boolean isPurchase_around_View() {
		return purchase_around_View;
	}
	public String getPurchase_color() {
		return purchase_color;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public int getPurchase_price() {
		return purchase_price;
	}
	public int getPurchase_dealer_No() {
		return purchase_dealer_No;
	}
	public String getPurchase_car_No() {
		return purchase_car_No;
	}

	
	
	public void setPurchase_no(int purchase_no) {
		this.purchase_no = purchase_no;
	}
	public void setPurchase_member_No(int purchase_member_No) {
		this.purchase_member_No = purchase_member_No;
	}
	public void setPurchase_sunRoof(boolean purchase_sunRoof) {
		this.purchase_sunRoof = purchase_sunRoof;
	}
	public void setPurchase_seat(boolean purchase_seat) {
		this.purchase_seat = purchase_seat;
	}
	public void setPurchase_around_View(boolean purchase_around_View) {
		this.purchase_around_View = purchase_around_View;
	}
	public void setPurchase_color(String purchase_color) {
		this.purchase_color = purchase_color;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	public void setPurchase_dealer_No(int purchase_dealer_No) {
		this.purchase_dealer_No = purchase_dealer_No;
	}
	public void setPurchase_car_No(String purchase_car_No) {
		this.purchase_car_No = purchase_car_No;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[구매번호 = ");
		builder.append(purchase_no);
		builder.append(", 회원번호 = ");
		builder.append(purchase_member_No);
		builder.append(", 선루프 = ");
		builder.append(purchase_sunRoof);
		builder.append(", 통풍시트 = ");
		builder.append(purchase_seat);
		builder.append(", 어라운드= ");
		builder.append(purchase_around_View);
		builder.append(", 차량색상= ");
		builder.append(purchase_color);
		builder.append(", 구매일 = ");
		builder.append(purchase_date);
		builder.append(", 구매금액 = ");
		builder.append(purchase_price);
		builder.append(", 딜러번호 = ");
		builder.append(purchase_dealer_No);
		builder.append(", 차량모델번호 = ");
		builder.append(purchase_car_No);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}
