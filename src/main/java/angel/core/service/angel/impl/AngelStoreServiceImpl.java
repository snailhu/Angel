package angel.core.service.angel.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import angel.core.domain.common.Product;
import angel.core.repository.common.ProductRepository;
import angel.core.service.angel.AngelStoreService;

public class AngelStoreServiceImpl implements AngelStoreService{
	
	@Resource
	private ProductRepository productRepository;

	private Pageable getPageable(int page, int size) {
		if (page <= 0)
			page = 1;
		if (size <= 0) {
			size = 20;
		}
		return new PageRequest(page - 1, size);
	}	

	@Override
	public void setTradingState(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTradingState(boolean state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Product> productList(int page, int size) {		
		return productRepository.findAll(getPageable(page,size));
	}
	
	
}
