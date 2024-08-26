package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBManager.DBManager;
import DTO.MemberSession;
import DTO.Reply;
import DTO.Review;

public class MemberReviewDAOImpl implements MemberReviewDAO {
	
	MemberSession memberSession = MemberSession.getInstance();
	
	DealerReviewDAO dealerReviewDAO = new DealerReviewDAOImpl();

	@Override
	public int reviewInsert(int sessionNum, String title, String content, int carStar, int dealerStar) {
		
		 String sql = "insert into review(re_no,purchase_no,title, content, car_star,deal_star) "
			 		+ "values (re_no_seq.nextval,purchase_no_seq.currval,?,?,?,?)";
		int result =0;
		Connection con=null;
		PreparedStatement ps=null;
			 
		 
		 try {
				 con = DBManager.getConnection();
				 ps = con.prepareStatement(sql);
				 
				 ps.setString(1, title);
				 ps.setString(2, content);
				 ps.setInt(3, carStar);
				 ps.setInt(4, dealerStar);
				 
				 result = ps.executeUpdate();
				 
				 
		 }catch(SQLException e) {
			 
		 }finally {
			 DBManager.dbClose(con, ps);
			 
		 }
		return result;
	}

	@Override
	public List<Review> reviewSelectAll() {
		 String reviewSql = "select * from review order by re_no desc";
		 
		List<Review> reviewList = new ArrayList<>();
		Review review = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		 
		 try {
				 con = DBManager.getConnection();
				 ps = con.prepareStatement(reviewSql);
				 rs = ps.executeQuery();
				 
				while(rs.next()) {
					review = new Review
							(rs.getInt(1),rs.getInt(2),rs.getString(3)
									,rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
					review.setReplyList(replySelectAll());
					reviewList.add(review);
				}
				
				DBManager.dbClose(con, ps, rs);
				
		 }catch(SQLException e) {
			 
		 }finally {
			 DBManager.dbClose(con, ps,rs);
			 
		 }
		return reviewList;
	}

	public List<Reply> replySelectAll() {
		
		String replySql = "select * from reply";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Reply reply =null;
		List<Reply> replyList = new ArrayList<Reply>();
		
		
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(replySql);
			rs = ps.executeQuery();
			
			
			reply = new Reply(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
			replyList.add(reply);
			
		}catch(Exception e) {
			
		}finally {
			DBManager.dbClose(con, ps,rs);
		}
		
		return replyList;
	}

	@Override
	public int reviewDelete(int sessionNum) {
		String sql = "delete from review where re_no = ?";
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sessionNum);  // 리뷰 번호로 삭제
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.dbClose(con, ps);
        }
        return result;
    }

	@Override
	public Review reviewDuplication() throws Exception{
		String sql = "select * from review where purchase_no = ?";
		Review review = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int memberNo=memberSession.getMemberNo();
		try {
			
		int purchaseNo = dealerReviewDAO.purchaseNumFindByMemberSessionNum(memberNo);
		
		
		
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, purchaseNo);
			rs = ps.executeQuery();
			if(purchaseNo==0) {
				if (rs.next()) {
					review = new Review(
							rs.getInt(1),
							rs.getInt(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getInt(6),
							rs.getString(7)
					);
				return review;
				}
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.dbClose(con, ps, rs);
		}
		return null;
	}
}
