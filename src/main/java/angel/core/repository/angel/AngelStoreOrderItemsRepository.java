package angel.core.repository.angel;

import org.springframework.data.jpa.repository.JpaRepository;

import angel.core.domain.angel.AngelStoreOrderItemPK;
import angel.core.domain.angel.AngelStoreOrderItems;

public interface AngelStoreOrderItemsRepository extends
		JpaRepository<AngelStoreOrderItems, AngelStoreOrderItemPK> {

}
