package com.novatesoft.awss3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsS3Config {
	
	@Value("${aws.s3.accesskey}")
	private String accessID;
	
	@Value("${secret}")
	private String secret;
	
	@Value("${region}")
	private String region;
	
	
	@Bean
	public AmazonS3 s3() {
		System.out.println("The accessId"+accessID);
		System.out.println("The secretid"+secret);
		AWSCredentials awsCredentials = new BasicAWSCredentials(accessID, secret);
		return  AmazonS3ClientBuilder.standard().withRegion("us-east-1").withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
		
		
	}
	
	

}
