package com.Course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Course.entity.Course;
import com.Course.repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private AWSS3Service awss3Service;

	public Course saveCourse(Course course, String url, String fileName) {

		String imageUrl = awss3Service.uploadFile(url, fileName);

		course.setImageUrl(imageUrl);

		return courseRepo.save(course);

	}

}
