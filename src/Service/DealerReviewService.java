package Service;

import java.sql.SQLException;
import java.util.List;

import DTO.Reply;
import DTO.Review;

public interface DealerReviewService 
{
	/**
	 * findBySessionNum() 호출후 구매번호를 받는다.
	 * 리뷰안에 구매번호와 리턴받은 구매번호중 일치하는것이 있는지없는지
	 * 확인하고 있다면 리뷰+답글을 리턴.
	 * 답글은 selectReplyByNum()를 호출 후 connection 같이 닫기.
	 * @param dealerId
	 * @return List<Review>
	 */
	List<Review> selectReviewByNum() throws SQLException;
	
	
	
	int findBySessionNum(int sessionNum) throws SQLException;
	
	
	
	/**
	 * replyDuplication()호출 후 리뷰를 리턴 받고,
	 * 리뷰의 리뷰번호를 갖고 Insert한다. 
	 */
	void replyInsert(int reviewNum,String content)throws SQLException;



	

}
