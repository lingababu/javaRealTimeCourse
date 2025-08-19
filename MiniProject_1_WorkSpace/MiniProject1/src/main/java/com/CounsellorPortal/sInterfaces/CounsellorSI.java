package com.CounsellorPortal.sInterfaces;

import com.CounsellorPortal.DTO.CounsellorDto;

public interface CounsellorSI {
	
	public boolean counsellorRegister(CounsellorDto counsellorDto);
	
	public CounsellorDto counsellorLogin(String email, String password);
	
	public boolean isEmailUnique(String email);	
	

}
