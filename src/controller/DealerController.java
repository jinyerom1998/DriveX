package controller;

import java.util.ArrayList;
import java.util.List;

import Service.Car;
import Service.DealerReviewService;
import Service.DealerService;
import Service.MemberReviewService;

public class DealerController {
	static DealerService dealerService = new DealerService();
	static MemberReviewService memberReviewService = new MemberReviewService();
	static DealerReviewService dealerReviewService = new DealerReviewService();
	
	public static void carQuantityPlusUpdate(String carName,int amount) {
		Car car = dealerService.carSelectByCarName(carName);
		dealerService.carQuantityPlusUpdate(car, amount);
	}
	
	public static void carSelectAll() {
		List<Car> listCar = new ArrayList<Car>();
		if (listCar.size==0) {
			throw new Exception("조회된 차량이 없습니다");
		}
		//listCar출력하는 뷰 출력
	}
	
	public static void dealerUpdate(String contents) {
		dealerService.dealerUpdate(contents);
	}
	
	public static void reviewSelectAll(/*딜러세션넘버*/) {
		dealerReviewService.replyDuplication(sessionNum);
		
	}
	
}
