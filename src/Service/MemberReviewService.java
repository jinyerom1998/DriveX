package Service;

import DAO.List;
import DAO.Reply;
import DAO.Review;

public interface MemberReviewService 
{
	/**
	 * 리뷰 등록하기
	 * @param sessionNum = 구매번호 => findBySessionNum()호출 후 받기.
	 * @param title = 제목
	 * @param content = 내용
	 * @param CarStar = 차 별점
	 * @param DealerStar = 딜러 별점
	 * @return int => 성공여부
	 */
	void reviewInsert(int sessionNum, String title,String content,int carStar, int dealerStar);
	//각 평점이 int형인지 double형인지.
	
	
	/**
	 * 전체 리뷰보기(답글포함) => replySelectAll()함수 호출 
	 * @return List<Review> = 리뷰리스트(답글포함)
	 */
	List<Review> reviewSelectAll();
	
	
	/**
	 * 전체 답글보기 
	 * @return List<Reply> = 답글리스트
	 */
	List<Reply> replySelectAll();
	
	
	/**
	 * 리뷰 삭제하기 => session 로그인된 현재 아이디의 회원번호와
	 * DealerReviewDAO.findBySessionNum()호출 후 
	 * int 구매번호를 받기
	 * @param MemberId
	 * @return int => 성공여부
	 */
	int reviewDelete(int sessionNum);
	
}
