package DAO;

import java.util.List;

public interface PurchaseDAO 
{
	
	
	/**
	 * 순서)1번. 딜러선택하기일때
	 * Dealer를 고를 때 보여주는 Dealer자기소개
	 * @return List<Dealer>
	 */
	List<Dealer> DealerChoice();
	
	/**
	 * 순서)2번. suv vs sedan 고르기할때 
	 * carSelectAll()호출 후 보여주기
	 */
	
	/**
	 * 순서)3번. 
	 * if suv를 선택하면 carSelectSuv를 보여주면서 선택하라고해.
	 * 그리고 입력값으로 carName받게해서
	 * 넘어가자.
	 * 그리고 carSelectByCarName을 호출 인수는 작성자가 입력한
	 * carName으로 주자.
	 * 
	 */
	
	/**
	 * 색상들의 예시를 띄워주고 고르게하기
	 * 순서)4번. 색상
	 * 만약 1번을 눌렀을 경우 String color = 베르비에화이트; 바꿔주기
	 * 
	 */
	
	/**
	 * 순서)5번.
	 * 첫번째 옵션 띄워주고 1번)구매 2번)선택안함 
	 * 그리고
	 * 두번째 ...
	 */
	
	/**
	 * 순서)6번.
	 * purchase 객체에다가 현재나온 임의로 나온 변수값들을 순서대로 넣어줄겁니다.
	 * total견적서를 띄워주고 구매번호랑 회원번호만 빼고 보여주기.
	 * 그다음에 1)구매하기-잔액이 다 있을 경우 순서 8번)으로 바로감
	 * 					-잔액이 없을 경우 순서7번)- 순서8)번 순으로 ㄱㄱ	
	 * 2)나가기
	 * 그리고 여기서 견적서를 테이블에 입력한다
	 */
	

	
	/**
	 * 순서)7번.
	 * 
	 * 잔액이 얼마 남았는지 보여주고 부족할 경우 예외처리로 잔고관리(충전메뉴)로 들어간다.
	 * 전 단계인 6단계의 상태와 똑같이 견적서를 갖고있는 상황으로 만들어준다. 
	 * ↓메소드는 잔액부족으로 충전하러갔을 때 메소드에서 호출하기.	 
	 * */
	//purchase객체에서 꺼내오기.
	
	
	/**
	 * 순서)8번.
	 * 구매완료 시 호출되어야할 DAO:
	 *  MemberDAO.balanceMinusUpdate를 호출하는데 인수로 purchase.gettotalPrice 값을 주는 메소드생성.
	 *  DealerDAO.carQuantityMinusUpdate를 호출. 
	 */
	
	
	int purchaseInsert(String sessionId,String carNo,int dealerNum,String color,int sunRoof,int coolSeat,int aroundView,int totalPrice);
	
}
