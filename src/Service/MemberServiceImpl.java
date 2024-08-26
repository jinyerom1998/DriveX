package Service;

import java.lang.reflect.Member;

import DAO.MemberDAO;
import DAO.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	MemberDAO memberDAO = new MemberDAOImpl();


	@Override
	public void memberInsert(String memberId, String name, int age, String address, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public Member login(String memberId, String password) {
		   Member member = memberDAO.login(memberId , password);
		   
		   if (member == null) {
		        //Exception
		    }
		   
		   return member;
		   }


	@Override
	public Member selectMemberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void balancePlusUpdate(String memberId, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void balanceMinusUpdate(String memberId, int amount) {
		// TODO Auto-generated method stub

	}

}
