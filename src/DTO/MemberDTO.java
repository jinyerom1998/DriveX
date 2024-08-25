package DTO;

public class MemberDTO {

	private int member_no;
	private String member_id;
	private String mamber_name;
	private int mamber_age;
	private String mamber_addr;
	private String mamber_pass;
	private int member_balance;
	
	public MemberDTO () {}

	public MemberDTO(int member_no, String member_id, String mamber_name, int mamber_age, String mamber_addr,
			String mamber_pass, int member_balance) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.mamber_name = mamber_name;
		this.mamber_age = mamber_age;
		this.mamber_addr = mamber_addr;
		this.mamber_pass = mamber_pass;
		this.member_balance = member_balance;
	}

	public int getMember_no() {
		return member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getMamber_name() {
		return mamber_name;
	}

	public int getMamber_age() {
		return mamber_age;
	}

	public String getMamber_addr() {
		return mamber_addr;
	}

	public String getMamber_pass() {
		return mamber_pass;
	}

	public int getMember_balance() {
		return member_balance;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public void setMamber_name(String mamber_name) {
		this.mamber_name = mamber_name;
	}

	public void setMamber_age(int mamber_age) {
		this.mamber_age = mamber_age;
	}

	public void setMamber_addr(String mamber_addr) {
		this.mamber_addr = mamber_addr;
	}

	public void setMamber_pass(String mamber_pass) {
		this.mamber_pass = mamber_pass;
	}

	public void setMember_balance(int member_balance) {
		this.member_balance = member_balance;
	}
	
	
	
	
}
