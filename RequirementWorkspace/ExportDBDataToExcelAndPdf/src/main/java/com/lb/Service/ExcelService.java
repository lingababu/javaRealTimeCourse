package com.lb.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.lb.Entity.UsersData;

@Service
public class ExcelService {
	
	public ByteArrayInputStream export(List<UsersData> data) throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("data");
		
		Row header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("EMail");
		
		int rowIdx =1;
		
		for(UsersData us :data) {
			
			Row row = sheet.createRow(rowIdx++);
			
			row.createCell(0).setCellValue(us.getId());
			row.createCell(1).setCellValue(us.getName());
			row.createCell(2).setCellValue(us.getEMail());
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		workbook.write(out);
		
		workbook.close();
		
		return new ByteArrayInputStream(out.toByteArray());
		
	}

}
