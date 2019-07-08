/**
 * 
 */
package com.shop.service;

import com.shop.models.Product;
import java.util.List;

/**
 * @author kartik.raina
 *
 */
public interface ProductServcie {

	List<Product> getAllProducts();
	
	Product searchProductById(long id);
	
	List<Product> searchProdcutsByName(String productName);
	
	boolean addProduct(Product newProduct);
	
	boolean deleteProductById(long productId);
}
