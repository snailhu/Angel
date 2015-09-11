package angel.core.repository.angel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import angel.core.domain.angel.AngelStore;

public interface AngelStoreRepository extends JpaRepository<AngelStore, Integer> {

	@Query("from AngelStore ans where ans.registration_Code=?1")
	public AngelStore findOneByCode(String code);
	
	@Query("from AngelStore ans where ans.angel_User.account=?1")
	public AngelStore findByAccount(String account);
}
