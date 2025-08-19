package com.usermanagement.entity;

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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;

	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private State state;

}
