package com.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
	
	private Long cartId;
	
	private Long userId;
	
	private Long productId;
	
	private Long quantity;
	
	private BigDecimal price;
	
	private ProductDto product;
}