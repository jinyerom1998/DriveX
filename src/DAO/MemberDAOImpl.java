package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DBManager;
import DTO.Member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int memberInsert(String memberId, String name, int age, String address, String password) {
		
		return 0;
	}


	@Override
	   public Member login(String memberId, String password) {//
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Member member = null;

	      try {
	         con = DBManager.getConnection();
	         ps = con.prepareStatement("select * from Member where memberId = ? and password = ?");
	         ps.setString(1, memberId);
	         ps.setString(2, password);

	         rs = ps.executeQuery();

	         if (rs.next()) {
	            member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
	                  rs.getString(6), rs.getInt(7));
	         }

	      }catch(SQLException e) {
	    	  
	      }
	      finally {
	         DBManager.dbClose(con, ps, rs);
	      }
	      return member;
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
