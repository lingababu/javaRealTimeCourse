package com.CounsellorPortal.sInterfaces;

import java.util.List;

import com.CounsellorPortal.DTO.DashboardDto;
import com.CounsellorPortal.DTO.EnquiryDto;

public interface EnquireSI {
	
	public boolean saveAndUpdateEnquires(EnquiryDto enquiryDto, Integer counsellorId);
	
	public List<EnquiryDto> getAllEnquiresBasedOnCounsellorId(Integer counsellorId);
	
	public List<EnquiryDto> getEnquiresBasedOnFilter(EnquiryDto filter, Integer cousellorId);
	
	public EnquiryDto getEnquiryToEdit(Integer enqId);
	
	public DashboardDto getDashboardInfo(Integer counsellorId);
	

	
	
	
	
	 
	

}
