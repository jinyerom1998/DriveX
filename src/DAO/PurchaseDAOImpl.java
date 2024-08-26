package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Dealer;
import DTO.MemberSession;
import DBManager.DBManager;

public class PurchaseDAOImpl implements PurchaseDAO
{

	private static PurchaseDAOImpl instance;

	public PurchaseDAOImpl() {}

	public static PurchaseDAOImpl getInstance()
	{
		if (instance == null)
		{
			instance = new PurchaseDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Dealer> getAllDealers() throws SQLException
	{
		List<Dealer> dealers = new ArrayList<>();
		String query = "SELECT dealer_no, dealer_id, self, rate FROM Dealer";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next())
			{
				Dealer dealer = new Dealer();
				dealer.setDealerNo(rs.getInt("dealer_no"));
				dealer.setDealerId(rs.getString("dealer_id"));
				dealer.setSelf(rs.getString("self"));
				dealer.setRate(rs.getInt("rate"));
				dealers.add(dealer);
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return dealers;
	}

	@Override
	public List<String> getCarListByType(String type) throws SQLException
	{
		List<String> carList = new ArrayList<>();
		String query = "SELECT car_name FROM Car WHERE car_type = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, type);
			rs = ps.executeQuery();

			while (rs.next())
			{
				carList.add(rs.getString("car_name"));
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return carList;
	}

	@Override
	public String getCarNoByCarName(String carName) throws SQLException
	{
		String carNo = null;
		String query = "SELECT car_no FROM Car WHERE car_name = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, carName);
			rs = ps.executeQuery();

			if (rs.next())
			{
				carNo = rs.getString("car_no");
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return carNo;
	}

	@Override
	public int purchaseInsert(String carNo, int dealerNum, String color, int sunRoof, int coolSeat, int aroundView, int totalPrice) throws SQLException {
		String query = "INSERT INTO Purchase (member_no, car_no, sunroof, seat, around_view, color, price, dealer_no) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int result;

		Connection conn = null;
		PreparedStatement ps = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);

			// 세션에서 member_no 가져오기
			int sessionNum = MemberSession.getInstance().getMemberNo();

			ps.setInt(1, sessionNum);
			ps.setString(2, carNo);
			ps.setInt(3, sunRoof);
			ps.setInt(4, coolSeat);
			ps.setInt(5, aroundView);
			ps.setString(6, color);
			ps.setInt(7, totalPrice);
			ps.setInt(8, dealerNum);

			result = ps.executeUpdate();
		}
		finally
		{
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return result;
	}

	@Override
	public int getBasePriceByCarNo(String carNo) throws SQLException
	{
		int basePrice = 0;
		String query = "SELECT price FROM Car WHERE car_no = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, carNo);
			rs = ps.executeQuery();

			if (rs.next())
			{
				basePrice = rs.getInt("price");
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return basePrice;
	}

	// 옵션 이름에 따라 옵션 가격을 가져옴
	@Override
	public int getSunRoofPrice() throws SQLException
	{
		return getOptionPriceByName("sunroof");
	}

	@Override
	public int getCoolSeatPrice() throws SQLException
	{
		return getOptionPriceByName("seat");
	}

	@Override
	public int getAroundViewPrice() throws SQLException
	{
		return getOptionPriceByName("around_view");
	}

	// 옵션 이름에 따라 값을 가져오는 함수
	private int getOptionPriceByName(String optionName) throws SQLException
	{
		int optionPrice = 0;
		String query = "SELECT option_price FROM CarOption WHERE option_name = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, optionName);
			rs = ps.executeQuery();

			if (rs.next())
			{
				optionPrice = rs.getInt("option_price");
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return optionPrice;
	}

	@Override
	public int updateMemberBalance(int memberNo, int amount) throws SQLException
	{
		String query = "UPDATE Member SET balance = balance - ? WHERE member_no = ?";
		Connection conn = null;
		PreparedStatement ps = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setInt(2, memberNo);
			return ps.executeUpdate();
		}
		finally
		{
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
	}

	@Override
	public int updateCarQuantity(String carNo, int amount) throws SQLException
	{
		String query = "UPDATE Car SET quantity = quantity - ? WHERE car_no = ?";
		Connection conn = null;
		PreparedStatement ps = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, carNo);
			return ps.executeUpdate();
		}
		finally
		{
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
	}

	@Override
	public int getBalanceBySessionId(int memberNo) throws SQLException
	{
		String query = "SELECT balance FROM Member WHERE member_no = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, memberNo);
			rs = ps.executeQuery();

			if (rs.next())
			{
				return rs.getInt("balance");
			}
		}
		finally
		{
			if (rs != null)
			{
				rs.close();
			}
			if (ps != null)
			{
				ps.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		return 0;
	}
}
