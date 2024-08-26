package DAO;

import java.util.List;

import DTO.Reply;
import DTO.Review;

public interface MemberReviewDAO 
{
	
	/**
	 * 리뷰 등록하기
	 * @param sessionNum = 로그인중인 번호 => DealerReviewDAO.findBySessionNum()호출 후 구매번호 받기.
	 * @param title = 제목
	 * @param content = 내용
	 * @param CarStar = 차 별점
	 * @param DealerStar = 딜러 별점
	 * @return int => 성공여부
	 */
	int reviewInsert(int sessionNum, String title,String content,int carStar, int dealerStar);
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
	 * 리뷰 삭제하기 => session 로그인된 현재 넘버의 회원번호와
	 * DealerReviewDAO.purchaseNumFindBySessionNum()호출 후 
	 * int 구매번호를 받기
	 * @param MemberId
	 * @return int => 성공여부
	 */
	int reviewDelete(int sessionNum);
	
	
	/**
	 * DealerReviewDAO.purchaseNumFindBySessionNum()호출 후
	 * 구매번호를 받아서 review의 해당 구매번호가 있는지 여부 확인.
	 * 만약 review에 해당 구매번호가 없다면 review리턴
	 * 있다면 이셉션 날려도됨.
	 */
	Review reviewDuplication(int sessionNum);
	
	
	
	
	
	
	
	
}
