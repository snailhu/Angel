package angel.core.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import angel.core.domain.customer.UserArea;

public interface UserAreaRespository extends JpaRepository<UserArea, Integer> {

}
