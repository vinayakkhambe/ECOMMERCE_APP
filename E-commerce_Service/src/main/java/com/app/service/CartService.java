package com.app.service;

import java.math.BigDecimal;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemRequest;
import com.app.entity.Cart;
import com.app.entity.CartItem;
import com.app.entity.Product;
import com.app.entity.User;
import com.app.repository.CartRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
     UserRepository userRepo;
	
	@Autowired
	ProductRepository pRepo;
	
	
	
	public void createEmptyCart(Long userId)
	{
		Cart newEmptyCart = new Cart();
		User cartOwner  = userRepo.findById(userId).get();
		newEmptyCart.setUser(cartOwner);
	}
	
	public void addToCart(CartItemRequest request , Long UserId)
	{ 
		
		User u = userRepo.findById(UserId).get();
		Cart cart =  u.getCart();
		Product p = pRepo.findById(request.getProductId()).get();
				
		CartItem item = new CartItem();
		item.setProduct(p);
		item.setCart(cart);
		item.setQuantity(request.getQuantity());
		
		BigDecimal Quantity = BigDecimal.valueOf(request.getQuantity());
		BigDecimal ProductPrice = p.getPrice();
		
		BigDecimal price = Quantity.multiply(ProductPrice);
		item.setPrice(price);
		
		
   
	}
	
}
