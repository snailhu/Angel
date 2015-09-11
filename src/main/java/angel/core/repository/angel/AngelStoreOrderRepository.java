package angel.core.repository.angel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import angel.core.domain.angel.AngelStore;
import angel.core.domain.angel.AngelStoreOrder;




import java.lang.Long;
import java.util.Date;
import java.util.List;


public interface AngelStoreOrderRepository extends JpaRepository<AngelStoreOrder, Long> {

	@Query("from AngelStoreOrder aso where aso.orderNum=?1")
	public AngelStoreOrder findByOrderNum(Long ordernum);
	
	@Query("from AngelStoreOrder aso where aso.angelStore=?1 and aso.createDateDetail<?2")
	public Page<AngelStoreOrder> findByAngelStoreAndDate(AngelStore Store,Date date,Pageable pageAble);
	
	@Query("from AngelStoreOrder aso where aso.angelStore=?1")
	public List<AngelStoreOrder> findByStore(AngelStore Store);
	
	@Query("from AngelStoreOrder aso where aso.angelStore=?1 and aso.createDateDetail<?2")
	public List<AngelStoreOrder> findByAngelStoreAndByLastMonth(AngelStore Store,Date date);
}
