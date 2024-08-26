package DTO;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

	private int purchaseNo;
	private int memberNo;
	private boolean sunRoof;
	private boolean seat;
	private boolean aroundView;
	private String color;
	private String purchaseDate;
	private int price;
	private int dealerNo;
	private String carNo;

	public Purchase () {}
	public Purchase(int purchaseNo, int memberNo, boolean sunRoof, boolean seat, boolean aroundView, String color,
			String purchaseDate, int price, int dealerNo, String carNo) {
		super();
		this.purchaseNo = purchaseNo;
		this.memberNo = memberNo;
		this.sunRoof = sunRoof;
		this.seat = seat;
		this.aroundView = aroundView;
		this.color = color;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.dealerNo = dealerNo;
		this.carNo = carNo;
	}


	public int getPurchaseNo() {
		return purchaseNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public boolean isSunRoof() {
		return sunRoof;
	}


	public boolean isSeat() {
		return seat;
	}


	public boolean isAroundView() {
		return aroundView;
	}


	public String getColor() {
		return color;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public int getPrice() {
		return price;
	}


	public int getDealerNo() {
		return dealerNo;
	}


	public String getCarNo() {
		return carNo;
	}


	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public void setSunRoof(boolean sunRoof) {
		this.sunRoof = sunRoof;
	}


	public void setSeat(boolean seat) {
		this.seat = seat;
	}


	public void setAroundView(boolean aroundView) {
		this.aroundView = aroundView;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setDealerNo(int dealerNo) {
		this.dealerNo = dealerNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[구매번호 = ");
		builder.append(purchaseNo);
		builder.append(", 회원번호 = ");
		builder.append(memberNo);
		builder.append(", 선루프 = ");
		builder.append(sunRoof);
		builder.append(", 통풍시트 = ");
		builder.append(seat);
		builder.append(", 어라운드= ");
		builder.append(aroundView);
		builder.append(", 차량색상= ");
		builder.append(color);
		builder.append(", 구매일 = ");
		builder.append(purchaseDate);
		builder.append(", 구매금액 = ");
		builder.append(price);
		builder.append(", 딜러번호 = ");
		builder.append(dealerNo);
		builder.append(", 차량모델번호 = ");
		builder.append(carNo);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}
