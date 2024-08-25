package DAO;

import java.util.List;

public interface DealerDAO 
{
	/**
	 * 로그인
	 * @param dealerId 아이디
	 * @param password 패스워드 
	 * @return int => 성공여부
	 */
	int login(String dealerId,String password);
	
	/**
	 * Dealer찾기
	 * 이름을 이용해서 해당 Dealer찾기 = session 을 이용해서 접속중인 현재 id를 이용해서 딜러찾기.
	 * @param dealerId = 회원아이디
	 * @return Dealer = 회원
	 */
	
	Dealer selectDealerById(String dealerId);
	
	/**
	 * 
	 * 딜러 자기소개수정
	 * @param contents = 자기소개란
	 * @param sessionId = 로그인중인 id
	 * @return int => 성공여부
	 */
	int dealerUpdate(String sessionId,String contents);
	
	
	/**
	 * 차 입고수량
	 * @param Car = 자동차 	=>carSelectByCarName()호출 후 리턴받기
	 * @param amount = 입고수량
	 * @return int => 성공여부
	 */
	int carQuantityPlusUpdate(Car car,int amount);
	
	
	/**
	 * 차 출고수량
	 * @param Car = 자동차 	=>carSelectByCarName()호출 후 리턴받기
	 * @param amount = 출고수량 (양수로 적기 ex) 차량구매시 int amount = 1로 되게 querry문 Quantity - ? 식으로 적기) 
	 * @return
	 */
	 int carQuantityMinusUpdate(Car car,int amount);
	 
	 
	 /**
	  *	SUV일때 차 조회
	  *
	  * @return List<Car> 
	  * "select * from CAR where 카테고리 like '%v%'  라는 쿼리문 쓰기.
	  */
	 List<Car> carSelectSuv();
	 
	 
	 /**
	  * 세단일때 차조회
	  * @return List<Car>
	  * "select * from CAR where not 카테고리 like '%v%' 라는 쿼리문 쓰기 
	  */
	 List<Car> carSelectSedan();
	 
	 
	 /**
	  * 모든 차 조회
	  * @return List<Car>
	  */
	 List<Car> carSelectAll();
	
	 
	 /**
	  * 특정 차 정보 찾기
	  * @param CarName
	  * @return Car
	  */
	 Car carSelectByCarName(String CarName);
	 
	 /**
	  * 딜러평점조회
	  * @param DealerId => 세션에서 현재 로그인되있는 딜러의 ID
	  * @return double => 'AVG 딜러평점' 해서 나온 값
	  */
	 double selectDealerStarByDealerId(String DealerId);
	 
}
