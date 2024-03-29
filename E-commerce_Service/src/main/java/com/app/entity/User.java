package com.app.entity;

import javax.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String address;

	
    @OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	

}
