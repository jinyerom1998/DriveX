package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.Dealer;

public class PurchaseDAOImpl implements PurchaseDAO {

	@Override
	public List<Dealer> DealerChoice() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCarListByType(String type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCarNoByCarName(String carName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColorPrice(String color) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSunRoofPrice() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoolSeatPrice() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAroundViewPrice() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int purchaseInsert(String sessionId, String carNo, int dealerNum, String color, int sunRoof, int coolSeat,
			int aroundView, int totalPrice) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBasePriceByCarNo(String carNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
