package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DealerReviewDAO;
import DAO.DealerReviewDAOImpl;
import DTO.Reply;
import DTO.Review;

public class DealerReviewServiceImpl implements DealerReviewService {

	DealerReviewDAO dao = new DealerReviewDAOImpl();
	
	@Override
	public List<Review> selectReviewByNum()throws SQLException
	{
			List <Review> list = new ArrayList<Review>();
			
			list = dao.selectReviewByNum();
			
			if(list.isEmpty())
			{
				throw new SQLException();
			}
			else
			return list;
	}

	

	@Override
	public void replyInsert(int reviewNo, String content)throws SQLException
	{
		int value = dao.replyInsert(reviewNo, content);
		
		if(value == 0)
		{
			throw new SQLException();
		}
		

	}



	@Override
	public int findBySessionNum(int sessionNum) throws SQLException 
	{	
			int value=0; 
		try {
			value = dao.purchaseNumFindByDealerSessionNum(sessionNum);
			
			if(value == 0 )
			{
				throw new SQLException();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return value; 
	}




}
