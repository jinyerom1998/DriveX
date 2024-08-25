package DTO;

public class ReviewDTO {

	private int reView_no;
	private int reView_purchase_NO;
	private String reView_title;
	private String reView_content;
	private int reView_car_Score;
	private int reView_dealer_Score;
	private String reView_reView_date;

	public ReviewDTO() {}
	public ReviewDTO(int reView_no, int reView_purchase_NO, String reView_title, String reView_content,
			int reView_car_Score, int reView_dealer_Score, String reView_reView_date) {
		super();
		this.reView_no = reView_no;
		this.reView_purchase_NO = reView_purchase_NO;
		this.reView_title = reView_title;
		this.reView_content = reView_content;
		this.reView_car_Score = reView_car_Score;
		this.reView_dealer_Score = reView_dealer_Score;
		this.reView_reView_date = reView_reView_date;
	}
	public int getReView_no() {
		return reView_no;
	}
	public int getReView_purchase_NO() {
		return reView_purchase_NO;
	}
	public String getReView_title() {
		return reView_title;
	}
	public String getReView_content() {
		return reView_content;
	}
	public int getReView_car_Score() {
		return reView_car_Score;
	}
	public int getReView_dealer_Score() {
		return reView_dealer_Score;
	}
	public String getReView_reView_date() {
		return reView_reView_date;
	}
	public void setReView_no(int reView_no) {
		this.reView_no = reView_no;
	}
	public void setReView_purchase_NO(int reView_purchase_NO) {
		this.reView_purchase_NO = reView_purchase_NO;
	}
	public void setReView_title(String reView_title) {
		this.reView_title = reView_title;
	}
	public void setReView_content(String reView_content) {
		this.reView_content = reView_content;
	}
	public void setReView_car_Score(int reView_car_Score) {
		this.reView_car_Score = reView_car_Score;
	}
	public void setReView_dealer_Score(int reView_dealer_Score) {
		this.reView_dealer_Score = reView_dealer_Score;
	}
	public void setReView_reView_date(String reView_reView_date) {
		this.reView_reView_date = reView_reView_date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[리뷰번호 = ");
		builder.append(reView_no);
		builder.append(", 구매번호 = ");
		builder.append(reView_purchase_NO);
		builder.append(", 제목 = ");
		builder.append(reView_title);
		builder.append(", 내용 = ");
		builder.append(reView_content);
		builder.append(", 차량평점 = ");
		builder.append(reView_car_Score);
		builder.append(", 딜러평점 = ");
		builder.append(reView_dealer_Score);
		builder.append(", 등록일=");
		builder.append(reView_reView_date);
		builder.append("]");
		return builder.toString();
	}
	
	

	
	
}
