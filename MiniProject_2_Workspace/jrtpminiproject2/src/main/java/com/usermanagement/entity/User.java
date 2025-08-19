package com.usermanagement.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;

	private String name;

	private String email;

	private Long phoneNumber;

	private String password;
	
	private String PasswordUpdated;

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country country;

	@ManyToOne
	@JoinColumn(name = "stateId")
	private State state;

	@ManyToOne
	@JoinColumn(name = "cityId")
	private City city;

}
