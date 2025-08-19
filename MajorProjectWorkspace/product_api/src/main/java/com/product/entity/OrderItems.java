package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	
	private String itemName;
	
	private String image_url;

	private Integer unitPrice;

	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
}
