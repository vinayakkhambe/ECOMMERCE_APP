package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Category;
import com.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<List<Product>> findByCategory(Category cat);

	
}
