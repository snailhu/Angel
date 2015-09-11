package angel.core.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import angel.core.domain.common.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	
}
