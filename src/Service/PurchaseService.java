package Service;

import java.sql.SQLException;
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
	 * purchase 객체에다가 현재 인수들 넣어줌
	 * total 견적서를 띄워주고 구매 번호랑 회원 번호만 빼고 보여줌
	 * 그 다음에 1) 구매하기 - 잔액이 다 있을 경우 순서 8번)으로 바로 감
	 *                     - 잔액이 없을 경우 순서 7번) - 순서 8번 순으로 진행
	 * 2) 나가기
	 * 그리고 여기서 견적서를 테이블에 입력한다
	 */
	//void preparePurchase(String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice);

	/**
	 * 순서) 7번.
	 *
	 * 잔액이 얼마 남았는지 보여주고 부족할 경우 예외 처리로 잔고 관리(충전 메뉴)로 들어감
	 * 전 단계인 6단계의 상태와 똑같이 견적서를 갖고 있는 상황으로 만들어줌
	 * 잔액 부족으로 충전하러 갔을 때 메소드에서 호출
	 */

	/**
	 * 순서) 8번.
	 * 구매 완료 시 호출되어야 할 DAO:
	 *  MemberDAO.balanceMinusUpdate를 호출하는데 인수로 purchase.getTotalPrice 값을 주는 메소드 생성.
	 *  DealerDAO.carQuantityMinusUpdate를 호출.
	 */
	void purchaseInsert(String carNo,int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice) throws SQLException;

	// ---------------- 추가된 부분 ----------------

	/**
	 * 차량 리스트를 카테고리(SUV 또는 Sedan)에 따라 가져오는 함수
	 * @param type 차량 타입 ("SUV", "Sedan")
	 * @return 차량 이름 리스트
	 */
	List<String> getCarListByType(String type) throws Exception;

	/**
	 * 차량 이름으로 차량 번호를 가져오는 함수
	 * @param carName 선택한 차량의 이름
	 * @return 차량 번호
	 */
	String getCarNoByCarName(String carName) throws SQLException;

	/**
	 * 총 가격 계산을 위한 함수
	 * @param carNo 차량 번호
	 * @param color 선택한 색상
	 * @param sunRoof 썬루프 옵션
	 * @param coolSeat 냉각 시트 옵션
	 * @param aroundView 어라운드 뷰 옵션
	 * @return 총 가격
	 */
	int calculateTotalPrice(String carNo, String color, int sunRoof, int coolSeat, int aroundView) throws SQLException;

	/**
	 * 잔액 확인 및 부족한 경우 처리하는 함수
	 *
	 * @param totalPrice 총 가격
	 * @return 잔액이 충분한지 여부
	 */
	boolean checkAndHandleBalance(int totalPrice) throws SQLException;

	/**
	 * 현재 사용자의 잔액을 반환하는 함수
	 * @return 현재 잔액
	 */
	int getBalance() throws SQLException;

	/**
	 * 사용자의 잔액을 충전하는 함수
	 * @param rechargeAmount 충전할 금액
	 */
	void rechargeBalance(int rechargeAmount) throws SQLException;
}
