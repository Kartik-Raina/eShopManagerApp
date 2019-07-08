/**
 * 
 */
package com.shop.persistence;

import com.shop.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kartik.raina
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> getProductByName(String productName);
	Product getProductById(long productId);
}
