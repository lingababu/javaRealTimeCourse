package com.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer productId;
	
	private String productName;
	
	private BigDecimal price;
	
	private String description;
	
	private String title;
	
	private Boolean active;
	
	private Integer units_stock;
	
	private String image;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "categoryId", nullable = false)
	private Categories category;

}
