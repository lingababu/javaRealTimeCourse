package com.CounsellorPortal.entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Counsellor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorId;

	private String name;

	private String email;

	private String password;

	private Long phoneNumber;

	@CreationTimestamp
	private LocalDate createdAt;

}
