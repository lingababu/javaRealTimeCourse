package com.Employee.service;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.entity.Employee;
import com.Employee.repo.EmployeeRepo;

@Service
public class ExcelService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public void readFromExcelAndSaveToDB(String filePath) throws Exception {

		FileInputStream fi = new FileInputStream(new File(filePath));

		Workbook wb = new XSSFWorkbook(fi);

		Sheet sheet = wb.getSheetAt(0);

		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				continue;
			}
			Employee emp = new Employee();
			emp.setName(row.getCell(0).getStringCellValue());
			emp.setEmail(row.getCell(1).getStringCellValue());
			
			employeeRepo.save(emp);
		}
		
		wb.close();
		fi.close();
	}

}
