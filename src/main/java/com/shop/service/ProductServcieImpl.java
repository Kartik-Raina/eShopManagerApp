/**
 * Service implementation for managing products.
 */
package com.shop.service;

import com.shop.models.Product;
import com.shop.persistence.ProductRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the ProductServcie interface.
 * Provides methods to manage products in the repository.
 *
 * @author kartik.raina
 */
@Service
public class ProductServcieImpl implements ProductServcie {

	@Autowired
	ProductRepository productRepo;

	/**
	 * Retrieves all products from the repository.
	 *
	 * @return a list of all products
	 */
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}

	/**
	 * Searches for a product by its ID.
	 *
	 * @param productId the ID of the product to search for
	 * @return the product with the specified ID, or null if not found
	 */
	@Override
	public Product searchProductById(long productId) {
		return productRepo.getProductById(productId);
	}

	/**
	 * Searches for products by their name.
	 *
	 * @param productName the name of the products to search for
	 * @return a list of products with the specified name
	 */
	@Override
	public List<Product> searchProdcutsByName(String productName) {
		return productRepo.getProductByName(productName);
	}

	/**
	 * Adds a new product to the repository.
	 *
	 * @param newProduct the product to add
	 * @return true if the product was added, false if a product with the same name already exists
	 */
	@Override
	public boolean addProduct(Product newProduct) {
		boolean productAdded;
		if(productRepo.getProductByName(newProduct.getName()).size() <= 0) {
			productRepo.save(newProduct);
			productAdded = true;
		} else {
			productAdded = false;
		}
		return productAdded;
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param productId the ID of the product to delete
	 * @return true if the product was deleted, false if the product was not found
	 */
	@Override
	public boolean deleteProductById(long productId) {
		boolean productDeleted;
		if(!Objects.isNull(productRepo.getProductById(productId))) {
			productRepo.deleteById(productId);
			productDeleted = true;
		} else {
			productDeleted = false;
		}
		return productDeleted;
	}

}