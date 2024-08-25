package controller;

import Service.MemberService;

public class BalanceController {
	static MemberService memberService = new MemberService();
	
	public static void balancePlusUpdate(String memberId,int amount){
		memberService.balancePlusUpdate(memberId, amount);
	}
	
	public static void balanceMinusUpdate(String memberId,int amount){
		memberService.balanceMinusUpdate(memberId, amount);
	}
}
