package DTO;


public class MemberSession {
	private int memberNo;
	private String memberId;
	private String Name;
	private int age;
	private String address;
	private String password;
	private int balance;
	
	private MemberSession() {}
	
	private static MemberSession ms = new MemberSession();
	
	public static MemberSession getInstance() {
		return ms;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getName() {
		return Name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public int getBalance() {
		return balance;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public MemberSession(int memberNo, String memberId, String name, int age, String address, String password,
			int balance) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		Name = name;
		this.age = age;
		this.address = address;
		this.password = password;
		this.balance = balance;
	}
	
	
}
