package com.CounsellorPortal.entity;

import java.time.LocalDate;
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
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;

	private String name;

	private Long phoneNumber;

	private String classMode;

	private String courseName;

	private String enquiryStatus;

	@CreationTimestamp
	private LocalDate createdAt;

	@UpdateTimestamp
	private LocalDate updatedAt;

	@ManyToOne
	@JoinColumn(name = "counsellorId")
	private Counsellor counsellor;
}
