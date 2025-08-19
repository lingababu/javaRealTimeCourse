package com.CounsellorPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CounsellorPortal.DTO.EnquiryDto;
import com.CounsellorPortal.sImpl.EnquireSImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquireController {

	@Autowired
	private EnquireSImpl enquireSImpl;

	@GetMapping("/viewEnquiryPage")
	public String addEnquiry(Model model) {

		EnquiryDto enquiryDto = new EnquiryDto();

		model.addAttribute("enquiry", enquiryDto);

		return "addEnquiry";

	}

	@PostMapping("/viewEnquiryPage")
	public String handleAddEnquiry(@ModelAttribute("enquiry") EnquiryDto enquiryDto, HttpServletRequest request,
			Model model) {

		HttpSession session = request.getSession(false);

		Integer cid = (Integer) session.getAttribute("CounsellorId");

		boolean status = enquireSImpl.saveAndUpdateEnquires(enquiryDto, cid);

		if (status) {
			model.addAttribute("smsg", "enquires saved sucessfully.");
		} else {
			model.addAttribute("emsg", "enquires saved failed");
		}
		return "addEnquiry";
	}

	@GetMapping("/viewEnquiries")
	public String getEnquiries(@ModelAttribute("enquiry") EnquiryDto enquiryDto, HttpServletRequest request,
			Model model) {

		HttpSession session = request.getSession(false);

		Integer cid = (Integer) session.getAttribute("CounsellorId");

		List<EnquiryDto> dtoList = enquireSImpl.getAllEnquiresBasedOnCounsellorId(cid);

		model.addAttribute("enqdtolist", dtoList);

		return "viewEnquiries";
	}

	@PostMapping("/filterEnqs")
	public String filterEnquires(@ModelAttribute("enquiry") EnquiryDto enquiryDto, HttpServletRequest request,
			Model model) {

		HttpSession session = request.getSession(false);

		Integer cid = (Integer) session.getAttribute("CounsellorId");

		List<EnquiryDto> dtoList = enquireSImpl.getEnquiresBasedOnFilter(enquiryDto, cid);

		model.addAttribute("enqdtolist", dtoList);

		return "viewEnquiries";
	}
	
	@GetMapping("/editEnquiry")
	public String editEnquiry(@RequestParam("Id") Integer Id, Model model) {
		
		EnquiryDto allEnquiresBasedOnCounsellorId = enquireSImpl.getEnquiryToEdit(Id);
		
		model.addAttribute("enquiry", allEnquiresBasedOnCounsellorId);
		
		return "addEnquiry";
		
	}
}
