package com.Course.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Course.entity.Course;
import com.Course.service.CourseService;

@Component 
public class CourseRunner implements ApplicationRunner {
	
	@Autowired
	CourseService courseService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String url = "C:\\Users\\addan_dw3d0p0\\OneDrive\\Desktop\\images1.JPG";
		
		String fileName ="images1.jpg";
		
		Course course = new Course();
		
		course.setName("Java");
		course.setDuration("ThreeMonths");
		course.setPrice(12000.00);
		course.setImageUrl(url);
		
		courseService.saveCourse(course, url, fileName);
		
		System.out.println("Course saved successfully.");
		

	}

}
