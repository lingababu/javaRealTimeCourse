package com.Employee.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Employee.service.ExcelService;

@Component
public class EmployeeRunner implements ApplicationRunner {

	@Autowired
	ExcelService excelService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String filePath ="C:\\Users\\addan_dw3d0p0\\OneDrive\\Desktop\\EmployeeData.xlsx";

		excelService.readFromExcelAndSaveToDB(filePath);

	}

}
