package DAO;

import java.util.List;

import DTO.Reply;
import DTO.Review;

public class MemberReviewDAOImpl implements MemberReviewDAO {

	@Override
	public int reviewInsert(int sessionNum, String title, String content, int carStar, int dealerStar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Review> reviewSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> replySelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reviewDelete(int sessionNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Review reviewDuplication(int sessionNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
