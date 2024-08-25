package DAO;


public interface MemberDAO 
{	
	
	/**
	 * 회원가입
	 * @return int =>성공여부
	 */
	int memberInsert(String memberId,String name, int age, String address, String password);
	
	
	/**
	 * 로그인
	 * @param memberId 아이디
	 * @param password 패스워드 
	 * @return	Member객체 =>session에 담기 위함.
	 */
	Member login(String memberId,String password);
	
	
	/**
	 * ID를 이용해서 해당 Member찾기
	 * @param memberId = 회원아이디
	 * @return Member = 회원
	 */
	Member selectMemberById(String memberId);
	
	
	/**
	 * 충전하기 
	 * 쿼리문으로 (balance = balance + amount)식으로 만들기
	 */
	int balancePlusUpdate(String sessionId,int Amount);
	
	
	/**
	 * 인출하기 or 차량구매 시 잔액
	 * 쿼리문으로 (balance = balance - amount)식으로 만들기
	 */
	int balanceMinusUpdate(String sessionId,int Amount);
	
	
}
