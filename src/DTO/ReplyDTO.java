package DTO;

public class ReplyDTO {

	private int reply_no;
	private int reply_reView_no;
	private String reply_content;
	private String reply_date;

	
	public ReplyDTO () {}
	public ReplyDTO(int reply_no, int reply_reView_no, String reply_content, String reply_date) {
		super();
		this.reply_no = reply_no;
		this.reply_reView_no = reply_reView_no;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
	}
	public int getReply_no() {
		return reply_no;
	}
	public int getReply_reView_no() {
		return reply_reView_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public void setReply_reView_no(int reply_reView_no) {
		this.reply_reView_no = reply_reView_no;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[답변글번호 = ");
		builder.append(reply_no);
		builder.append(", 리뷰글번호 = ");
		builder.append(reply_reView_no);
		builder.append(", 내용 = ");
		builder.append(reply_content);
		builder.append(", 답변등록일 = ");
		builder.append(reply_date);
		builder.append("]");
		return builder.toString();
	}

	
	
}
