package DTO;

public class DealerDTO {

	private int dealer_no;
	private String dealer_id;
	private String dealer_pass;
	private String dealer_option;
	private String dealer_self;
	private int dealer_score;
	
	public DealerDTO () {}

	public DealerDTO(int dealer_no, String dealer_id, String dealer_pass, String dealer_option, String dealer_self,
			int dealer_score) {
		super();
		this.dealer_no = dealer_no;
		this.dealer_id = dealer_id;
		this.dealer_pass = dealer_pass;
		this.dealer_option = dealer_option;
		this.dealer_self = dealer_self;
		this.dealer_score = dealer_score;
	}

	public int getDealer_no() {
		return dealer_no;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public String getDealer_pass() {
		return dealer_pass;
	}

	public String getDealer_option() {
		return dealer_option;
	}

	public String getDealer_self() {
		return dealer_self;
	}

	public int getDealer_score() {
		return dealer_score;
	}

	public void setDealer_no(int dealer_no) {
		this.dealer_no = dealer_no;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public void setDealer_pass(String dealer_pass) {
		this.dealer_pass = dealer_pass;
	}

	public void setDealer_option(String dealer_option) {
		this.dealer_option = dealer_option;
	}

	public void setDealer_self(String dealer_self) {
		this.dealer_self = dealer_self;
	}

	public void setDealer_score(int dealer_score) {
		this.dealer_score = dealer_score;
	}
	
	
	
	
}
