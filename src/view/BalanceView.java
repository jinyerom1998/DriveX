package view;

import java.util.Scanner;

public class BalanceView {
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			
			System.out.println("userID와 잔액 출력하는 곳(세션)");
			//SesseionSet ss = SessionSet.getInstance();
			//System.out.println(ss.getSet());
			
			BalanceView.printMenu();
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				//컨트롤러.충전(); // 충전하기
				break;
			case 2 :
				//컨트롤러.인출(); // 인출하기
				break;
			case 3 :
				return;
			default:
				System.out.println("1, 2, 3 중에서만 입력 바랍니다.");
			}
		}
	}

	public static void printMenu() {
		System.out.println("=== DriveX Member Menu ===");
		System.out.print("1. 충전하기   |   2. 인출하기   |  3. 나가기");
	}
}
