package io.spring.s3Upload;

import java.io.File;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Bucket {

	public static void main(String[] args) {

		String accessKey = "AKIAVFIWI357UJ5G4DWF";
		String secretKey = "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";
		String region = "ap-south-1";
		String bucketName = "lbjavabucket";
		String filePath = "C:\\Users\\addan_dw3d0p0\\OneDrive\\Desktop\\lb.txt";
		String keyName = "lb.txt";

		BasicAWSCredentials awscreds = new BasicAWSCredentials(accessKey, secretKey);

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awscreds)).build();

		File file = new File(filePath);

		PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file);

		s3Client.putObject(request);

		System.out.println("File uploaded successfully to s3 bucket: " + bucketName);

	}

}
