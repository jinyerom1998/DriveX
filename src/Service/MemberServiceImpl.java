package Service;

import java.sql.SQLException;

import DAO.MemberDAO;
import DAO.MemberDAOImpl;
import DTO.Member;
import DTO.MemberSession;

public class MemberServiceImpl implements MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();
	MemberSession session = MemberSession.getInstance(); 



	@Override
	public void memberInsert(String memberId, String name, int age, String address, String password)
			throws SQLException {
		int result = memberDAO.memberInsert(memberId, name, age, address, password);

		if (result == 0) {
			throw new SQLException("회원가입 오류입니다.");
		}
	}


	public Member selectMemberById(String memberId) throws SQLException {
		Member member = memberDAO.selectMemberById(memberId);

		if (!member.equals(memberId)) {
			throw new SQLException("정보가 일치하지 않습니다.");
		}

		return member;
	}

	@Override
	public void balancePlusUpdate(String memberId, int Amount) throws SQLException {
		memberDAO.balancePlusUpdate(memberId, Amount);

	}

	@Override
	public void balanceMinusUpdate(String memberId, int Amount2) throws SQLException {
		memberDAO.balanceMinusUpdate(memberId, Amount2);
	}

	@Override
	public int balanceSelect() throws SQLException {

		return memberDAO.balanceSelect(session.getMemberId());

	}


}
