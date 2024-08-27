package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Reply;
import DTO.Review;
import Service.DealerReviewService;
import Service.DealerReviewServiceImpl;
import Service.MemberReviewService;
import Service.MemberReviewServiceImpl;

public class ReviewController {
	static DealerReviewService dealerReviewService = new DealerReviewServiceImpl();
	static MemberReviewService memberReviewService = MemberReviewServiceImpl.getInstance();
	
	public static void findBySessionNum(int sessionNum) {
		int result=0;
		
		//현재 로그인된 세션넘버가 구매내역테이블의 세션과 일치하는지 확인해야 한다->
		try {
			result = memberReviewService.purchaseNumFindByMemberSessionNum(sessionNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result==0) {

			//throw new Exception();

		}
		
	}
	
	
	public static void reviewInsert(String title,String content,int carStar, int dealerStar) {
		try {
			memberReviewService.reviewInsert(title, content, carStar, dealerStar);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void reviewDelete(int sessionNum) {
		try {
			memberReviewService.reviewDelete(sessionNum);
		}catch (Exception e) {
			// 삭제하려는 번호의 리뷰글이 없습니다 failView출력
			System.out.println("삭제하려는 번호의 리뷰글이 없습니다");
		}
	}


	public static void reviewSelectAll() {
		List<Review> listReview = new ArrayList<>();
		
		listReview = memberReviewService.reviewSelectAll();
		System.out.println(listReview);
    }
}
