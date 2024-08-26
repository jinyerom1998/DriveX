package DAO;

import DTO.Member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int memberInsert(String memberId, String name, int age, String address, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member login(String memberId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectMemberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int balancePlusUpdate(String sessionId, int Amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int balanceMinusUpdate(String sessionId, int Amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
