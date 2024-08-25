package Service;

import java.lang.reflect.Member;

public interface MemberService 
{	
	/**
	 * 회원가입
	 * @return int =>성공여부
	 */
	void memberInsert(String memberId,String name, int age, String address, String password);
	
	
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
	 */
	void balancePlusUpdate(String memberId,int amount);
	
	
	/**
	 * 인출하기 or 차량구매 시 잔액
	 */
	void balanceMinusUpdate(String memberId,int amount);
}
