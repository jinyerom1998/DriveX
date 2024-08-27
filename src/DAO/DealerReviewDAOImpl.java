package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import DTO.DealerSession;
import DTO.MemberSession;
import DTO.Reply;
import DTO.Review;

public class DealerReviewDAOImpl implements DealerReviewDAO {
	
	MemberSession memberSession = MemberSession.getInstance();
	DealerSession dealerSession = DealerSession.getInstance();
	
	MemberReviewDAO memberRiviewDAO = new MemberReviewDAOImpl();
	
	

	@Override
	public List<Review> selectReviewByNum() throws SQLException 
	{
		int sessionNum = dealerSession.getDealerNo();
		Review re = new Review();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList<Review>();
		List<Reply> list2 = new ArrayList<Reply>();
		String sql = "SELECT * FROM REVIEW WHERE RE_NO = ?";
		
		int purchaseNum = purchaseNumFindByDealerSessionNum(sessionNum);

		Review review = memberRiviewDAO.reviewDuplication(purchaseNum);
		
		try {
			if (review != null) {
				while (rs.next()) {
					con = DBManager.getConnection();
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();

					list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getInt(6), rs.getString(7)));

					list2 = selectReplyByNum(con, sessionNum);
					re.setReplyList(list2);
					
				}
				return list;

			} else {
				return null;
			}

		} finally {
			DBManager.dbClose(con, ps, rs);
		}
		
	}

	@Override
	public List<Reply> selectReplyByNum(Connection con, int sessionNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<Reply>();
		String sql = "SELECT * FROM REPLY WHERE RE_NO = ?";
		int purchaseNum = purchaseNumFindByDealerSessionNum(sessionNum);

		Review review = memberRiviewDAO.reviewDuplication(purchaseNum);

		int replyDupNum = replyDuplication(review.getReviewNo());

		try {
			if (replyDupNum >= 1) {

				while (rs.next()) {
					ps = con.prepareStatement(sql);
					ps.setInt(1, replyDupNum);
					rs = ps.executeQuery();

					list.add(new Reply(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));

				}
				return list;
			} else {
				throw new SQLException();
			}

		}

		finally {
			DBManager.dbClose(null, ps, rs);

		}

	}

	@Override
	public int purchaseNumFindByDealerSessionNum(int sessionNum) throws SQLException 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int purchaseNum = 0;
		String sql = "SELECT PURCHASE_NO FROM PURCHASE WHERE DEALER_NO = ?";

		try {
			
				con = DBManager.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, sessionNum);
				rs = ps.executeQuery();
				

				if (rs.next()) {
				purchaseNum = rs.getInt(1);

				if (purchaseNum == 0) {
					throw new SQLException();

				} else {
					return purchaseNum;

			}
				}
		}
		finally {
			DBManager.dbClose(con, ps, rs);
		}
		return 0;
		
	}



	@Override
	public int replyInsert(int reviewNo,String content) throws SQLException
	{
		int sessionNum = dealerSession.getDealerNo();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reply reply = null;
		String sql = "INSERT INTO REPLY(REPLY_NO,RE_NO,REPLY_CONTENT,REPLY_DATE)VALUES(REPLY_NO_SEQ.NEXTVAL ,?,?,SYSDATE)";
		int result = 0;
		
		try
		{
			int replyDupNum=replyDuplication(sessionNum);
			if(replyDupNum == 0) 
			{
				
				con=DBManager.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, reviewNo);
				ps.setString(2, content);
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					reply = new Reply(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
				}
				
				result = ps.executeUpdate();
				
				
				return result;
			}
			return 0;
		
		
		}
		finally
		{
			DBManager.dbClose(con, ps, null);
		}
	}

	@Override
	public int replyDuplication(int sessionNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Review review = memberRiviewDAO.reviewDuplication(sessionNum);
		int reviewNum = review.getReviewNo();

		String sql = "SELECT RE_NO FROM REPLY";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				reviewNum = rs.getInt(1);

				if (reviewNum != 0) {
					throw new SQLException();
				} else {
					return reviewNum;
				}
			}

		} finally {
			DBManager.dbClose(con, ps, rs);

		}
		return 0;

	}

}
