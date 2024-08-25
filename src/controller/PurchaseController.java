//package controller;
//
//import Service.DealerReviewService;
//
//public class PurchaseController {
//	static DealerReviewService dealerReviewService = new DealerReviewService();
//
//	public static void findBySessionNum(int sessionNum) {
//		int result = 0;
//		result = dealerReviewService.findBySessionNum(sessionNum); //구매내역 찾기
//		if(result==0) { //없으면
//			throw new Exception("구매내역이 없습니다"); //예외발생
//		}
//
//		//구매내역 있으면 그걸 출력하는 서비스의 메소드 호출
//	}
//}
