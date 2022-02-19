package com.blackwater.blackwaterbillingmanagementsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSS3Config {
	 
	// Access key id will be read from the application.properties file during the application initialization.
	@Value("${aws.access_key_id}")
	private String accessKeyId;
	// Secret access key will be read from the application.properties file during the application initialization.
	@Value("${aws.secret_access_key}")
	private String secretAccessKey;
	// Region will be read from the application.properties file  during the application initialization.
	@Value("${aws.s3.region}")
	private String region;
 
	@Bean
	public AmazonS3 getAmazonS3Cient() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		// Get AmazonS3 client and return the s3Client object.
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
	}
}
