package com.app.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	private Long quantity;
	
	private BigDecimal price;
	
	@ManyToOne()
	@JoinColumn(name = "cart_id")
	private Cart cart;

}
