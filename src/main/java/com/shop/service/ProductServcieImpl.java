/**
 * 
 */
package com.shop.service;

import com.shop.models.Product;
import com.shop.persistence.ProductRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kartik.raina
 *
 */
@Service
public class ProductServcieImpl implements ProductServcie {
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product searchProductById(long productId) {
		return productRepo.getProductById(productId);
	}

	@Override
	public List<Product> searchProdcutsByName(String productName) {
		return productRepo.getProductByName(productName);
	}

	@Override
	public boolean addProduct(Product newProduct) {
		boolean productAdded;
		if(productRepo.getProductByName(newProduct.getName()).size() <= 0) {
			productRepo.save(newProduct);
			productAdded = true;
		}else {
			productAdded = false;
		}
		return productAdded;
	}

	@Override
	public boolean deleteProductById(long productId) {
		boolean productDeleted;
		if(!Objects.isNull(productRepo.getProductById(productId))) {
			productRepo.deleteById(productId);
			productDeleted = true;
		}else {
			productDeleted = false;
		}
		
		return productDeleted;
	}

}
