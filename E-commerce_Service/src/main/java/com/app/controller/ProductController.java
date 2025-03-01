package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entity.Product;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;

@RestController
@RequestMapping("/ecom/products")
public class ProductController {

	@Autowired
	private ProductService productService;

   //test	
	
	@GetMapping("/test")
	public ResponseEntity<String> test()
	{
		return ResponseEntity.accepted().body("worked");
	}
	
	//create product
	
	@PostMapping("/create/{categoryid}")
	public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable Long categoryid) {
		Product savedProduct = productService.createProduct(product, categoryid);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	//Retrive (get) product by id
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		Product getProduct = productService.getById(id);
		return ResponseEntity.ok(getProduct);
	}
	
	//Retrive all products
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> list = productService.getAllProducts();
		return ResponseEntity.ok(list);
	}

	//retrive All By category
	
	  @GetMapping("/category/{CategoryType}")
		public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable  String CategoryType)
		{
			List<Product> list = productService.getAllProductsByCategory(CategoryType);
			return ResponseEntity.ok(list);
			
		}

	//Update product
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		if (updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}
		return ResponseEntity.notFound().build();
	}

	
	// Delete product
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
