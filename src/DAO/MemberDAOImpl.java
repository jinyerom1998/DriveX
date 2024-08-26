package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DBManager;
import DTO.Member;

public class MemberDAOImpl implements MemberDAO {
	
	@Override

	public int memberInsert(String memberId, String name, int age, String address, String password) throws SQLException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int result = 0;

	    try {
	        con = DBManager.getConnection();
	        ps = con.prepareStatement(
	            "INSERT INTO member (member_no, member_id, name, age, address, password, balance) " +
	            "VALUES (member_no_seq.nextval, ?, ?, ?, ?, ?, 0)"
	        );

	        // PreparedStatement에 파라미터 설정
	        ps.setString(1, memberId);
	        ps.setString(2, name);
	        ps.setInt(3, age);
	        ps.setString(4, address);
	        ps.setString(5, password);

	        result = ps.executeUpdate();
	    } finally {
	        DBManager.dbClose(con, ps);
	    }

	    return result;
	}	
	
	@Override
	public Member login(String memberId, String password) throws SQLException {//
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "select * from Member where member_Id = ? and password = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberId);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.dbClose(con, ps, rs);
		}
		return member;
	}

	/**
	 * ID를 이용해서 해당 Member찾기
	 * 
	 * @param memberId = 회원아이디
	 * @return Member = 회원
	 */
	@Override
	public Member selectMemberById(String memberId) throws SQLException {//
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("select * from Member where memberId=?");
			ps.setString(1, memberId);

			rs = ps.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
	
		} finally {
			DBManager.dbClose(con, ps, rs);
		}

		return member;
	}

	
	
	/**
	 * 충전하기 쿼리문으로 (balance = balance + amount)식으로 만들기
	 */
	
	@Override
	public int balancePlusUpdate(String sessionId, int Amount) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("update member set balance = balance + ?");
			ps.setInt(1, Amount);

		} finally {
			DBManager.dbClose(con, ps);
		}

		return result;
	}



	@Override
	public int balanceMinusUpdate(String sessionId, int Amount) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}	
