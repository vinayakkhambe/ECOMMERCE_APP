package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.app.entity.Category;
import com.app.entity.Product;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
    CategoryService categoryService;
	
	@PostMapping("/create")
	 public Category createCategory(@RequestBody Category category)
	 {
		return categoryService.createCategory(category);
	 }
	
	@PutMapping("/update/{categoryId}")
	 public Category updateCategory( @PathVariable Long categoryId,@RequestBody Category updatedCategory)
	 {
		return categoryService.updateCategory(categoryId, updatedCategory);
	 }
	
	@DeleteMapping("/delete/{categoryId}")
	 public void deleteCategory(@PathVariable Long categoryId) 
	 {
		categoryService.deleteCategory(categoryId);
	 }

}
