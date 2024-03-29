//
//import java.math.BigDecimal;
//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "orders")
//public class Order extends BaseEntity{
//	
//	@ManyToOne
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
//	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<OrderItem> orderItems;
//	
//	@Column(name = "total_price")
//	private BigDecimal totalPrice;
//
//}
