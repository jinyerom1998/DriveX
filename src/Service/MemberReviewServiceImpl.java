package Service;

import java.util.List;

import DAO.MemberReviewDAO;
import DAO.MemberReviewDAOImpl;
import DTO.Reply;
import DTO.Review;

public class MemberReviewServiceImpl implements MemberReviewService {
	private static MemberReviewService instance = new MemberReviewServiceImpl();
	private MemberReviewDAO memberReviewDao = MemberReviewDAOImpl.getInstance();
			
	private MemberReviewServiceImpl() {}
    public static MemberReviewService getInstance() {
		return instance;
	}
	@Override
	public void reviewInsert(int sessionNum, String title, String content, int carStar, int dealerStar) {
		int result = memberReviewDao.reviewInsert(sessionNum, title, content, carStar, dealerStar);

		if(result==0) {
			//Exception
		}

	}

	@Override
	public List<Review> reviewSelectAll() {
		List<Review> list = memberReviewDao.reviewSelectAll();
		if(list.isEmpty()) {
			//Exception
		}
		return list;
	}

	@Override
	public List<Reply> replySelectAll() {
		List<Reply> list = memberReviewDao.replySelectAll();
		if(list.isEmpty()) {
			//Exception
		}
		return list;
	}

	@Override
	public void reviewDelete(int sessionNum) {
		int result = memberReviewDao.reviewDelete(sessionNum);
		if(result==0) {
			//Exception
		}
	}

}
