/**
 * 
 */
package com.shop.controller;

import com.shop.models.Product;
import com.shop.service.ProductServcie;
import com.shop.utils.CommonUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kartik.raina
 *
 */

@RestController
@RequestMapping("/shop/")
public class ProductController {

	@Autowired
	private ProductServcie productServcie;

	@Value("${service.health.message}")
	private String healthCheckMessage;
	
	@Value("${product.add.success.mesaage}")
	private String productAddSuccessMessage;
	
	@Value("${product.add.fail.mesaage}")
	private String productAddFailMessage;
	
	@Value("${product.delete.success.mesaage}")
	private String productDeleteSuccessMessage;
	
	@Value("${product.delete.fail.mesaage}")
	private String productDeleteFailMessage;

	@GetMapping("/")
	public ResponseEntity<Object> healthCheck(HttpServletRequest request) {
		return ResponseEntity.ok(CommonUtils.populateResponseObject(HttpStatus.OK.toString(), null, healthCheckMessage,
				request.getRequestURI()));
	}

	@GetMapping("product/")
	public ResponseEntity<Object> getAllProducts(HttpServletRequest request){
		return ResponseEntity.ok(CommonUtils.populateResponseObject(HttpStatus.OK.toString(), null, CommonUtils.convertToJson(productServcie.getAllProducts()), request.getRequestURI()));
	}

	@GetMapping("product/{id}")
	public ResponseEntity<Object> searchProductById(@PathVariable(name = "id") long productId, HttpServletRequest request) {
		return ResponseEntity.ok(CommonUtils.populateResponseObject(HttpStatus.OK.toString(), null, CommonUtils.convertToJson(productServcie.searchProductById(productId)), request.getRequestURI()));
	}

	@PostMapping("product/")
	public ResponseEntity<Object> addNewProduct(@Validated @RequestBody Product newProduct, HttpServletRequest request) {
		boolean newProductAdded = productServcie.addProduct(newProduct);
		if (newProductAdded) {
			return ResponseEntity.status(HttpStatus.CREATED).body(CommonUtils.populateResponseObject(HttpStatus.CREATED.toString(), null, productAddSuccessMessage, request.getRequestURI()));
		} else {
			return ResponseEntity.badRequest().body(CommonUtils.populateResponseObject(HttpStatus.BAD_REQUEST.toString(), null, productAddFailMessage, request.getRequestURI()));
		}
	}

	@DeleteMapping("product/{id}")
	public ResponseEntity<Object> deleteProductById(@PathVariable(name = "id") long productId, HttpServletRequest request) {
		boolean productDeleted = productServcie.deleteProductById(productId);
		if (productDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body(CommonUtils.populateResponseObject(HttpStatus.OK.toString(), null, productDeleteSuccessMessage, request.getRequestURI()));
		} else {
			return ResponseEntity.badRequest().body(CommonUtils.populateResponseObject(HttpStatus.BAD_REQUEST.toString(), null, productDeleteFailMessage, request.getRequestURI()));
		}
	}
}
