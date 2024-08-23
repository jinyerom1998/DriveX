package view;

import java.util.Scanner;

public class ReviewView {
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			
			System.out.println("userID와 잔액 출력하는 곳(세션)");
			//SesseionSet ss = SessionSet.getInstance();
			//System.out.println(ss.getSet());
			
			ReviewView.printMenu();
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				//검증먼저 한다 그다음에 아래코드 실행
				ReviewView.register(); // 등록
				break;
			case 2 :
				//컨트롤러의 조회함수 호출 // 게시글 조회
				break;
			case 3 :
				ReviewView.deleteReview(); //리뷰게시글 삭제
				break;
			case 4 : 
				System.out.println("후기게시판을 종료합니다.");
				return;
			default:
				System.out.println("1, 2, 3, 4 중에서만 입력 바랍니다.");
			}
		}
	}

	public static void printMenu() {
		System.out.println("=== DriveX Member Review Board ===");
		System.out.println("1. 등록   |   2. 조회   |  3. 삭제  |  4. 나가기");
	}
	
	public static void register() {
		System.out.println("리뷰의 제목을 입력하세요");
		String title = sc.nextLine();
		System.out.println("리뷰의 내용을 입력하세요");
		String content = sc.nextLine();		
		System.out.println("차량의 평점(1부터 5 사이의 정수)을 입력하세요");
		int carStar = Integer.parseInt(sc.nextLine());
		System.out.println("딜러의 평점(1부터 5 사이의 정수)을 입력하세요");
		int dealStar = Integer.parseInt(sc.nextLine());
		
		//Review review = new Review(title, content, carStar, dealStar));
		//컨트롤러의 register함수 호출(인수: review)
	}
	
	public static void deleteReview() {
		System.out.println("삭제할 글번호를 알려주세요");
		int reNo = Integer.parseInt(sc.nextLine());
		//컨트롤러의 삭제함수 호출(인수: reNo)
	}
}
