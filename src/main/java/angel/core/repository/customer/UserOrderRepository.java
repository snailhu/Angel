package angel.core.repository.customer;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.customer.UserOrder;
import angel.core.domain.customer.UserOrderState;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
	
	@Query("from UserOrder uo where uo.state=?1")
	public Page<UserOrder> findByState(UserOrderState State, Pageable pageAble);
	
	@Query("from UserOrder uo where uo.state=?1 and uo.finishDate<?2")
	public Page<UserOrder> findByDate(UserOrderState State, Pageable pageAble,Date date);
	
	
	@Query("from UserOrder uo where uo.orderNum=?1")
	public UserOrder findByOrderNum(Long orderNum); 
	
	@Query("from UserOrder uo where uo.angelStore=?1")
	public List<UserOrder> findOrderByStore(AngelStore store);
	
	@Query("from UserOrder uo where uo.angelStore=?1 and uo.month=?2 and uo.year=?3")
	public List<UserOrder> findOrderByMonth(AngelStore store,int month,int year);
	
//	@Query(value="select * from UserOrder where angelstore_id=?1 and DATE(createDate)=DATE(?2)",nativeQuery=true)
//	public Page<UserOrder> findOrderToday(int id,Date date,Pageable pageAble);
	
	@Query("from UserOrder uo where uo.angelStore=?1 and uo.createDateYMD=?2")
	public Page<UserOrder> findOrderToday(AngelStore store,Date date,Pageable pageAble);
	
	@Query("from UserOrder uo where uo.angelStore=?1 and uo.createDateDetail<?2")
	public List<UserOrder> findOrderByLastMonth(AngelStore store,Date date);
	
	@Query("from UserOrder uo where uo.angelStore=?1 and uo.year=?2 and uo.month=?3 and uo.day<?4")
	public List<UserOrder> findOrderByThisMonth(AngelStore store,int year,int month,int day);
	
}
