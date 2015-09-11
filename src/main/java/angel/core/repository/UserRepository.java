package angel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import angel.core.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User us where us.account=?1")
	public User findUserByAccount(String account);
}
