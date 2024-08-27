package view;

import java.util.Scanner;

import DTO.MemberSession;
import controller.BalanceController;

public class BalanceView {
	static Scanner sc = new Scanner(System.in);
	MemberSession session = MemberSession.getInstance(); 
	
	public static void menu() {
		while(true) {
			
			System.out.println("userID와 잔액 출력하는 곳(세션)");
			//SesseionSet ss = SessionSet.getInstance();
			//System.out.println(ss.getSet());
			
			BalanceView.printMenu();
			
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				BalanceView.balancePlusUpdate();// 충전하기
				break;
			case 2 :
				BalanceView.balanceMinusUpdate();// 인출하기
				break;
			case 3 :
				return;
			default:
				System.out.println("1, 2, 3 중에서만 입력 바랍니다.");
			}
		}
	}


	public static void balancePlusUpdate() {
		System.out.println("충전할 금액을 입력하세요 : ");
		int amount = Integer.parseInt(sc.nextLine());
		
		System.out.println("충전할 아이디를 입력하세요 : ");
		String memberId = sc.nextLine();
		
		int balance = BalanceController.balanceSelect(); //DB에서 현재 잔액 조회
		System.out.println("현재금액 : "+ balance); //충전 전 금액
		
		BalanceController.balancePlusUpdate(memberId,amount); //충전->DB가 바뀜
		
		balance = BalanceController.balanceSelect(); //DB에서 현재 잔액 조회->충전 된 금액
		System.out.println("충전 후 금액 : "+ balance);
	}
	
	public static void balanceMinusUpdate() {
		System.out.println("인출할 금액을 입력하세요: ");
		int amount1 = Integer.parseInt(sc.nextLine());
		System.out.println("인출할 아이디를 입력해 주세요 : ");
		String memberId = sc.nextLine();
		BalanceController.balanceMinusUpdate(memberId,amount1);
	}


	public static void printMenu() {
		System.out.println("=== DriveX Member Menu ===");
		System.out.print("1. 충전하기   |   2. 인출하기   |  3. 나가기");
	}
}
