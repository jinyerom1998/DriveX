package DAO;

import java.sql.Connection;
import java.util.List;

import DTO.Reply;
import DTO.Review;

public class DealerReviewDAOImpl implements DealerReviewDAO {

	@Override
	public List<Review> selectReviewByNum(int sessionNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> selectReplyByNum(Connection con, int sessionNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int purchaseNumFindBySessionNum(int sessionNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyInsert(int sessionNum, String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyDuplication(int sessionNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
