package com.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;

	private String itemName;

	private String imageUrl;

	private Integer quantity;

	private double unitPrice;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Products products;

	@ManyToOne
	@JoinColumn(name = " orderId")
	private Orders orders;

}
