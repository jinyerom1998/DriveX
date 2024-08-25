package controller;

import Service.DealerService;
import Service.MemberService;
import view.DealerMenuView;
import view.MemberMenuView;

public class LoginController {
	static MemberService memberService = new MemberService();
	static DealerService dealerService = new DealerService();
	
	public void login(String memberId, String password) {
		try {
			//if memberId가 딜러id용 문자 포함하고 있다면->
			dealerService.login(memberId, password);
			DealerMenuView.menu();
			
			//else->
			memberService.login(memberId, password);
			MemberMenuView.menu();
			
		}catch (Exception e) {
			// 존재하지 않는 회원 id입니다 failview출력
		}
	}
}
