package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.Dealer;

public interface PurchaseDAO {

	/**
	 * 순서) 1번. 딜러 선택하기일 때
	 * Dealer를 고를 때 보여주는 Dealer 자기소개
	 * @return List<Dealer> 딜러 목록
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	List<Dealer> DealerChoice() throws SQLException;

	/**
	 * 순서) 2번. SUV vs Sedan 고르기할 때
	 * 차량의 타입에 따라 (SUV 또는 Sedan) 차량 목록을 가져옵니다.
	 * @param type 차량 타입 (SUV, Sedan)
	 * @return 차량 이름 목록
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	List<String> getCarListByType(String type) throws SQLException;

	/**
	 * 순서) 3번.
	 * if SUV를 선택하면 carSelectSuv를 보여주면서 선택하라고 합니다.
	 * 그리고 입력값으로 carName을 받아서
	 * carSelectByCarName을 호출, 인수로는 작성자가 입력한
	 * carName을 전달합니다.
	 *
	 * 차량 이름으로 차량 번호를 가져옵니다.
	 * @param carName 차량 이름
	 * @return 차량 번호
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	String getCarNoByCarName(String carName) throws SQLException;

	/**
	 * 순서) 4번. 색상 선택
	 * 색상들의 예시를 띄워주고 고르게 합니다.
	 * 예를 들어, 1번을 눌렀을 경우 String color = "베르비에화이트"로 바꿔줍니다.
	 *
	 * 색상에 따른 가격을 가져옵니다.
	 * @param color 선택한 색상
	 * @return 색상 가격
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int getColorPrice(String color) throws SQLException;

	/**
	 * 순서) 5번 1
	 * 첫번째 옵션 띄워주고 1번) 구매 2번) 선택 안함
	 * 그리고 두번째 ...
	 *
	 * 썬루프 옵션에 따른 가격을 가져옵니다.
	 * @return 썬루프 옵션 가격
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int getSunRoofPrice() throws SQLException;

	/**
	 * 순서) 5번 2
	 * 냉각 시트 옵션에 따른 가격을 가져옵니다.
	 * @return 냉각 시트 옵션 가격
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int getCoolSeatPrice() throws SQLException;

	/**
	 * 순서) 5번 3
	 * 어라운드뷰 옵션에 따른 가격을 가져옵니다.
	 * @return 어라운드뷰 옵션 가격
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int getAroundViewPrice() throws SQLException;

	/**
	 * 순서) 6번.
	 * purchase 객체에다가 현재 임의로 나온 변수 값들을 순서대로 넣어줍니다.
	 * total 견적서를 띄워주고 구매 번호랑 회원 번호만 빼고 보여줍니다.
	 * 그 다음에 1) 구매하기 - 잔액이 다 있을 경우 순서 8번으로 바로 이동
	 *                     - 잔액이 없을 경우 순서 7번으로 이동한 후 8번 순으로 진행
	 * 2) 나가기
	 * 여기서 견적서를 테이블에 입력합니다.
	 *
	 * 구매 정보를 데이터베이스에 삽입합니다.
	 * @param sessionId 사용자 세션 ID
	 * @param carNo 차량 번호
	 * @param dealerNum 딜러 번호
	 * @param color 색상
	 * @param sunRoof 썬루프 옵션
	 * @param coolSeat 냉각 시트 옵션
	 * @param aroundView 어라운드 뷰 옵션
	 * @param totalPrice 총 가격
	 * @return 삽입된 행의 수 (성공적으로 삽입된 경우 1 이상)
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int purchaseInsert(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice) throws SQLException;

	/**
	 * 순서) 7번.
	 * 잔액이 얼마 남았는지 보여주고 부족할 경우 예외 처리로 잔고 관리(충전 메뉴)로 들어갑니다.
	 * 전 단계인 6단계의 상태와 똑같이 견적서를 갖고 있는 상황으로 만들어줍니다.
	 * ↓메소드는 잔액 부족으로 충전하러 갔을 때 메소드에서 호출하기.
	 *
	 * 차량 번호로 차량의 기본 가격을 가져옵니다.
	 * @param carNo 차량 번호
	 * @return 차량 기본 가격
	 * @throws SQLException 데이터베이스 접근 중 예외 발생 시
	 */
	int getBasePriceByCarNo(String carNo) throws SQLException;

	/**
	 * 순서) 8번.
	 * 구매 완료 시 호출되어야 할 DAO:
	 *  MemberDAO.balanceMinusUpdate를 호출하는데 인수로 purchase.getTotalPrice 값을 주는 메소드 생성.
	 *  DealerDAO.carQuantityMinusUpdate를 호출.
	 */
}
