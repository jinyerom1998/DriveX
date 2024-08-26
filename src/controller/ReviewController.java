package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Review;
import Service.DealerReviewService;
import Service.DealerReviewServiceImpl;
import Service.MemberReviewService;
import Service.MemberReviewServiceImpl;

public class ReviewController {
	static DealerReviewService dealerReviewService = new DealerReviewServiceImpl();
	static MemberReviewService memberReviewService = new MemberReviewServiceImpl();
	
	public static void findBySessionNum(int sessionNum) throws SQLException {
		int result=0;
		
		//현재 로그인된 세션넘버가 구매내역테이블의 세션과 일치하는지 확인해야 한다->
		try {
			result = dealerReviewService.findBySessionNum(sessionNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result==0) {
			throw new SQLException();
		}
		
	}
	
	public static void reviewSelectAll() {
		List<Review> listReview = new ArrayList<>();
		
		listReview = memberReviewService.reviewSelectAll();
		
		if(listReview.size()==0) {
			//등록된 리뷰가 없습니다 예외 발생
		}else {
			//등록된 리뷰 출력 뷰 호출
		}
	}
	
	public static void reviewInsert(int sessionNum, String title,String content,int carStar, int dealerStar) {
		memberReviewService.reviewInsert(sessionNum, title, content, carStar, dealerStar);
	}
	
	public static void reviewDelete(int sessionNum) {
		try {
			memberReviewService.reviewDelete(sessionNum);
		}catch (Exception e) {
			// 삭제하려는 번호의 리뷰글이 없습니다 failView출력
		}
	}
}
