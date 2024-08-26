package DAO;

import java.util.List;

import DTO.Car;
import DTO.Dealer;

class DealerDAOImpl implements DealerDAO {

	@Override
	public int login(String dealerId, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Dealer selectDealerById(String dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dealerUpdate(String sessionId, String contents) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int carQuantityPlusUpdate(Car car, int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int carQuantityMinusUpdate(Car car, int amount) {
		// TODO Auto-generated method stub
		return 0;
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
