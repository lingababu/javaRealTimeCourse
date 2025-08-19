package com.CounsellorPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CounsellorPortal.entity.Enquiry;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
	
	public List<Enquiry> findByCounsellorCounsellorId(Integer cId);
	
}
