package Service;

import java.util.List;

import DTO.Car;
import DTO.Dealer;

public class DealerServiceImpl implements DealerService {

	@Override
	public void login(String dealerId, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dealer selectMemberById(String dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dealerUpdate(String contents) {
		// TODO Auto-generated method stub

	}

	@Override
	public void carQuantityPlusUpdate(Car car, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void carQuantityMinusUpdate(Car car, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> carSelectSuv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> carSelectSedan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> carSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car carSelectByCarName(String CarName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double selectDealerStarByDealerId(String DealerId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
