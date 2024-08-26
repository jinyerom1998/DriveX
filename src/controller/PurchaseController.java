package controller;

import java.sql.SQLException;
import java.util.List;

import DTO.Dealer;
import Service.PurchaseService;
import Service.PurchaseServiceImpl;
import view.PurchaseView;

public class PurchaseController {
	// 싱글톤으로 사용될 서비스 인스턴스
//	static DealerReviewService dealerReviewService = DealerReviewServiceImpl.getInstance();
//
//	public static void findBySessionNum(int sessionNum) {
//		int result = 0;
//		result = dealerReviewService.findBySessionNum(sessionNum); // 구매내역 찾기
//		if (result == 0) { // 없으면
//			// 예외를 발생시키는 대신 메시지를 표시할 수도 있습니다.
//			// throw new Exception("구매내역이 없습니다"); // 예외발생
//			System.out.println("구매내역이 없습니다.");
//		}
//	}

	/**
	 * 구매 프로세스를 시작하는 메서드
	 */
	public static void startPurchase() {
		try {
			PurchaseService purchaseService = PurchaseServiceImpl.getInstance(); // 싱글톤 인스턴스 사용?

			// 1. 딜러 선택하기
			List<Dealer> dealers = purchaseService.DealerChoice();
			Dealer selectedDealer = PurchaseView.displayDealersAndSelect(dealers);

			// 2. 차량 타입 및 모델 선택
			int carTypeChoice = PurchaseView.chooseCarType();
			List<String> carList = (carTypeChoice == 1) ? purchaseService.getCarListByType("SUV") : purchaseService.getCarListByType("Sedan");
			String selectedCarName = PurchaseView.displayCarsAndSelect(carList);

			// 3. 차량 번호 선택
			String carNo = purchaseService.getCarNoByCarName(selectedCarName);

			// 4. 색상 선택, 변수에 저장
			String selectedColor = PurchaseView.chooseColor();

			// 5. 옵션 선택
			int sunRoof = PurchaseView.chooseSunRoofOption();
			int coolSeat = PurchaseView.chooseSeatOption();
			int aroundView = PurchaseView.chooseAroundViewOption();

			// 6. 총 비용 계산
			int totalPrice = purchaseService.calculateTotalPrice(carNo, selectedColor, sunRoof, coolSeat, aroundView);
			PurchaseView.displayTotalPrice(totalPrice);

			// 7. 구매 과정 처리
			boolean confirmPurchase = PurchaseView.confirmPurchase();
			if (confirmPurchase) {
				boolean balanceSufficient = purchaseService.checkAndHandleBalance(totalPrice);
				if (!balanceSufficient) { // 잔고가 부족한 경우
					PurchaseView.displayInSufficientBalance();

					// 충전 여부 확인
					boolean rechargeDecision = PurchaseView.confirmRecharge();
					if (rechargeDecision)
					{ // 충전하는 경우
						int rechargeAmount = PurchaseView.enterRechargeAmount(totalPrice - purchaseService.getBalance());
						purchaseService.rechargeBalance(rechargeAmount);

						balanceSufficient = purchaseService.checkAndHandleBalance(totalPrice); // 전체 금액으로 다시 확인
						if (balanceSufficient)
						{
							finalizePurchase(carNo, selectedDealer.getDealerNo(), selectedColor, sunRoof, coolSeat, aroundView, totalPrice);
						}
						else
						{ // 충전했는데도 잔액이 부족하다면 주문 취소
							PurchaseView.displayInSufficientBalance();
							PurchaseView.displayPurchaseCancelled();
							return; // 상위 메뉴로 올라감
						}
					}
					else
					{ // 충전하지 않는 경우 주문 취소
						PurchaseView.displayPurchaseCancelled();
						return;
					}
				}
				else
				{ // 잔고가 충분한 경우
					finalizePurchase(carNo, selectedDealer.getDealerNo(), selectedColor, sunRoof, coolSeat, aroundView, totalPrice);
					PurchaseView.displayPurchaseSuccess();
				}
			}
			else
			{ // 구매를 취소하는 경우
				PurchaseView.displayPurchaseCancelled();
			}

		} catch (SQLException e) {
			// SQLException 처리
			e.printStackTrace(); // 임시 메시지
		} catch (Exception e) {
			// 기타 예외 처리
			e.printStackTrace(); // 임시 메시지
		}
	}

	/**
	 * 구매를 완료하는 메서드, 구매내역에 인서트 되는 경우
	 */
	static void finalizePurchase(String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice) {
		PurchaseService purchaseService = PurchaseServiceImpl.getInstance(); // 싱글톤 인스턴스 사용
        try
		{
            purchaseService.purchaseInsert(carNo, dealerNum, color, sunRoof, coolSeat, aroundView, totalPrice);
        }
		catch (SQLException e)
		{
            //sql exception 에러처리
        }
        PurchaseView.displayPurchaseSuccess();
	}
}
