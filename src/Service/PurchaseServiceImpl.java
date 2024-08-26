package Service;

import java.util.List;

import DTO.Dealer;

public class PurchaseServiceImpl implements PurchaseService {

	@Override
	public List<Dealer> DealerChoice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preparePurchase(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat,
			int aroundView, int totalPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handleInsufficientBalance(String sessionId, int totalPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void purchaseInsert(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat,
			int aroundView, int totalPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getCarListByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCarNoByCarName(String carName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateTotalPrice(String carNo, String color, int sunRoof, int coolSeat, int aroundView) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkAndHandleBalance(String sessionId, int totalPrice) {
		// TODO Auto-generated method stub
		return false;
	}

}
