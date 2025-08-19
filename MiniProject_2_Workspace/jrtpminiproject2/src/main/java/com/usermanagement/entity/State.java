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
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;

	private String stateName;

	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country country;
}
