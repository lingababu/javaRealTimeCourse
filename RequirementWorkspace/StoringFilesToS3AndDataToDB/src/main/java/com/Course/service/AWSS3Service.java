package com.Course.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import jakarta.annotation.PostConstruct;

@Service
public class AWSS3Service {

	@Value("${aws.accessKey}")
	private String accessKey;

	@Value("${aws.secretKey}")
	private String secretKey;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	private AmazonS3 s3Client;

	@PostConstruct
	public void init() {
		AWSCredentials awsCred = new BasicAWSCredentials(accessKey, secretKey);

		s3Client = AmazonS3ClientBuilder.standard().withRegion("ap-south-1")
				.withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
	}

	public String uploadFile(String filePath, String fileName) {

		try {
			File file = new File(filePath);

			if (file.exists()) {
				PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file);

				s3Client.putObject(request);
				return s3Client.getUrl(bucketName, fileName).toString();
			} else {
				throw new IllegalArgumentException("File not found: " + fileName);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error uploading file to s3: " + e.getMessage());
		}
	}

}
