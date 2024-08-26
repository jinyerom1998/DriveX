package controller;

import java.util.ArrayList;
import java.util.List;

import DTO.Review;
import Service.DealerReviewService;
import Service.DealerReviewServiceImpl;
import Service.MemberReviewService;
import Service.MemberReviewServiceImpl;
import view.ReviewView;

public class ReviewController {
	static DealerReviewService dealerReviewService = new DealerReviewServiceImpl();
	static MemberReviewService memberReviewService = MemberReviewServiceImpl.getInstance();
	
	public static void findBySessionNum(int sessionNum) {
		int result=0;
		
		//현재 로그인된 세션넘버가 구매내역테이블의 세션과 일치하는지 확인해야 한다->
		result = dealerReviewService.findBySessionNum(sessionNum);
		
		if(result==0) {
			//throw new Exception();
		}
		
	}
	
	public static void reviewSelectAll() {
		List<Review> listReview = new ArrayList<>();
		
		listReview = memberReviewService.reviewSelectAll();
		for(Review re : listReview) {
			System.out.println(re);
		}
		
		
		/*if(listReview.isEmpty()) {
			//등록된 리뷰가 없습니다 예외 발생
		}else {
			ReviewView.reviewSelectAll();
		}*/
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
