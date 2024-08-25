package controller;

import Service.DealerReviewService;

public class PurchaseController {
	static DealerReviewService dealerReviewService = new DealerReviewService();

	public static void findBySessionNum(int sessionNum) {
		int result = 0;
		result = dealerReviewService.findBySessionNum(sessionNum); //구매내역 찾기
		if(result==0) { //없으면
			throw new Exception("구매내역이 없습니다"); //예외발생
		}

		//구매내역 있으면 그걸 출력하는 서비스의 메소드 호출

        /**
         * 구매 프로세스를 시작하는 메서드
         * 1. 딜러 선택
         *    - PurchaseService의 DealerChoice()를 호출하여 딜러 목록을 가져옴
         *    - PurchaseView의 displayDealerChoicesAndSelect()를 호출하여 사용자에게 딜러 선택 UI를 보여주고 선택된 딜러를 반환
         * 2. 차량 타입 선택 (SUV vs Sedan)
         *    - PurchaseView의 chooseCarType()을 호출하여 사용자에게 차량 타입 선택 UI를 보여주고 선택된 타입을 반환
         * 3. 차량 이름으로 차량 선택
         *    - 선택된 차량 타입에 따라 PurchaseService의 getCarListByType()을 호출하여 해당 차량 타입의 차량 목록을 가져옴
         *    - PurchaseView의 displayCarChoicesAndSelect()를 호출하여 사용자에게 차량 목록을 보여주고 선택된 차량 이름을 반환
         *    - 선택된 차량 이름을 기반으로 PurchaseService의 getCarNoByCarName()을 호출하여 차량 번호를 가져옴
         * 4. 색상 선택
         *    - PurchaseView의 chooseColor()를 호출하여 사용자에게 색상 선택 UI를 보여주고 선택된 색상을 반환
         * 5. 옵션 선택 (썬루프, 냉각 시트, 어라운드 뷰)
         *    - PurchaseView의 chooseSunRoofOption(), chooseCoolSeatOption(), chooseAroundViewOption()을 각각 호출하여 옵션 선택 UI를 보여주고 선택된 옵션을 반환
         * 6. 견적서 생성 및 가격 확인
         *    - PurchaseService의 calculateTotalPrice()를 호출하여 선택한 옵션에 따라 총 가격을 계산
         *    - PurchaseView의 displayTotalPrice()를 호출하여 계산된 가격을 사용자에게 보여줌
         * 7. 잔액 확인 및 처리
         *    - 잔액 확인:
         *      - PurchaseService의 checkAndHandleBalance()를 호출하여 사용자의 잔액이 충분한지 확인
         *      - 잔액이 부족한 경우: PurchaseView의 displayInsufficientBalance()를 호출하여 잔액 부족을 알림
         *    - 부족한 금액 충전 여부 확인:
         *      - PurchaseView의 confirmRecharge()를 호출하여 충전할지 여부를 사용자에게 확인
         *      - 충전할 경우: PurchaseView의 enterRechargeAmount()를 호출하여 충전할 금액을 입력받고, PurchaseService의 rechargeBalance()를 호출하여 잔액을 충전
         *      - 충전 후 재확인: PurchaseService의 checkAndHandleBalance()를 다시 호출하여 잔액이 충분한지 재확인
         *      - 잔액이 여전히 부족한 경우: PurchaseView의 displayInsufficientBalance()를 다시 호출
         *    - 충전하지 않을 경우: PurchaseView의 displayPurchaseCancelled()를 호출하여 구매 취소를 알림
         * 8. 구매 최종 확정
         *    - PurchaseService의 purchaseInsert()를 호출하여 구매 정보를 저장
         *    - PurchaseView의 displayPurchaseSuccess()를 호출하여 구매 성공 메시지를 표시
         * @param sessionId 사용자 세션 ID
         */
        //void startPurchase(String sessionId);

        /**
         * 구매를 완료하는 메서드
         * 1. 잔액 차감
         *    - PurchaseService의 purchaseInsert() 호출 시 내부적으로 잔액을 차감
         * 2. 차량 수량 감소
         *    - PurchaseService의 purchaseInsert() 호출 시 내부적으로 차량 수량을 감소
         * 3. 구매 정보 저장
         *    - PurchaseService의 purchaseInsert()를 호출하여 구매 정보를 저장
         * 4. 구매 성공 메시지 표시
         *    - PurchaseView의 displayPurchaseSuccess()를 호출하여 구매 성공 메시지를 사용자에게 표시
         * @param sessionId 사용자 세션 ID
         * @param carNo 차량 번호
         * @param dealerNum 딜러 번호
         * @param color 선택한 색상
         * @param sunRoof 썬루프 옵션
         * @param coolSeat 냉각 시트 옵션
         * @param aroundView 어라운드 뷰 옵션
         * @param totalPrice 총 가격
         */
        //void finalizePurchase(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice);
	}
}
