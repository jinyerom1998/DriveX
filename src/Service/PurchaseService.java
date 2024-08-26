package Service;

import java.util.List;

import DTO.Dealer;

public interface PurchaseService {

	/**
	 * 순서) 1번. 딜러 선택하기일 때
	 * Dealer를 고를 때 보여주는 Dealer 자기소개
	 * @return List<Dealer>
	 */
	List<Dealer> DealerChoice();

	/**
	 * 순서) 6번.
	 * purchase 객체에다가 현재 나온 임의로 나온 변수값들을 순서대로 넣어줄겁니다.
	 * total 견적서를 띄워주고 구매 번호랑 회원 번호만 빼고 보여주기.
	 * 그 다음에 1) 구매하기 - 잔액이 다 있을 경우 순서 8번)으로 바로 감
	 *                     - 잔액이 없을 경우 순서 7번) - 순서 8번 순으로 진행
	 * 2) 나가기
	 * 그리고 여기서 견적서를 테이블에 입력한다
	 */
	void preparePurchase(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice);

	/**
	 * 순서) 7번.
	 *
	 * 잔액이 얼마 남았는지 보여주고 부족할 경우 예외 처리로 잔고 관리(충전 메뉴)로 들어간다.
	 * 전 단계인 6단계의 상태와 똑같이 견적서를 갖고 있는 상황으로 만들어준다.
	 * 잔액 부족으로 충전하러 갔을 때 메소드에서 호출하기.
	 */
	boolean handleInsufficientBalance(String sessionId, int totalPrice);

	/**
	 * 순서) 8번.
	 * 구매 완료 시 호출되어야 할 DAO:
	 *  MemberDAO.balanceMinusUpdate를 호출하는데 인수로 purchase.getTotalPrice 값을 주는 메소드 생성.
	 *  DealerDAO.carQuantityMinusUpdate를 호출.
	 */
	void purchaseInsert(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice);

	// ---------------- 추가된 부분 ----------------

	/**
	 * 차량 리스트를 카테고리(SUV 또는 Sedan)에 따라 가져오는 함수
	 * @param type 차량 타입 ("SUV", "Sedan")
	 * @return 차량 이름 리스트
	 */
	List<String> getCarListByType(String type);

	/**
	 * 차량 이름으로 차량 번호를 가져오는 함수
	 * @param carName 선택한 차량의 이름
	 * @return 차량 번호
	 */
	String getCarNoByCarName(String carName);

	/**
	 * 총 가격 계산을 위한 함수
	 * @param carNo 차량 번호
	 * @param color 선택한 색상
	 * @param sunRoof 썬루프 옵션
	 * @param coolSeat 냉각 시트 옵션
	 * @param aroundView 어라운드 뷰 옵션
	 * @return 총 가격
	 */
	int calculateTotalPrice(String carNo, String color, int sunRoof, int coolSeat, int aroundView);

	/**
	 * 잔액 확인 및 부족한 경우 처리하는 함수
	 * @param sessionId 사용자 세션 ID
	 * @param totalPrice 총 가격
	 * @return 잔액이 충분한지 여부
	 */
	boolean checkAndHandleBalance(String sessionId, int totalPrice);
}
