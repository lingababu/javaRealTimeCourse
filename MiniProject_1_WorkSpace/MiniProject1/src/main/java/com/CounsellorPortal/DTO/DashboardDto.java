package com.CounsellorPortal.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardDto {

	private Integer totalEnquires;
	private Integer open;
	private Integer enrolled;
	private Integer lost;

}
