package Service;

import java.sql.SQLException;

import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DTO.Member;

public class MemberServiceImpl implements MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();

	/**
	 * 회원가입
	 * 
	 * @return int =>성공여부
	 * @throws Exception 
	 */

	@Override
	public void memberInsert(String memberId, String name, int age, String address, String password) throws Exception {
		int result = memberDAO.memberInsert(memberId, name, age, address, password);
				
		if (result == 0) {
			throw new Exception("회원가입 오류입니다.");
		}
	}

	/**
	 * 로그인
	 * @param memberId 아이디
	 * @param password 패스워드 
	 * @throws SQLException 
	 */
	@Override
	public Member login(String memberId, String password) throws SQLException {
	Member member = memberDAO.login(memberId , password);
	
	if (member == null) {
        throw new SQLException("로그인 실패: 아이디나 비밀번호가 잘못되었습니다.");
    }
	
	return member;
	}

	/**
	 * ID를 이용해서 해당 Member찾기
	 * @param memberId = 회원아이디
	 * @return Member = 회원
	 */
	@Override
	public Member selectMemberById(String memberId) {
	Member member = memberDAO.selectMemberById(memberId);
	
	if (! member.equals(memberId)) {
		throw new NotFoundException("정보가 일치하지 않습니다.");
	}
		
	
	return member;
	}

	@Override
	public void balancePlusUpdate(String memberId, int Amount) {
	Member member =  memberDAO.balancePlusUpdate(memberId, Amount);
	
	}

	@Override
	public void balanceMinusUpdate(String memberId, int Amount) {
		Member member =  memberDAO.balanceMinusUpdate(memberId, Amount);
		
	}

}
