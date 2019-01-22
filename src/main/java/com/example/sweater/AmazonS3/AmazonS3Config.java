package com.example.sweater.AmazonS3;
/*
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
@Configuration

public class AmazonS3Config {
     @Value("${amazon.aws.access-key-id}")
        private String awsKeyId;

        @Value("${amazon.aws.access-key-secret}")
        private String awsKeySecret;

        @Value("${amazon.s3.region}")
        private String awsRegion;

        @Value("${amazon.s3.default-bucket}")
        private String awsS3Bucket;

        @Bean(name = "awsKeyId")
        public String getAWSKeyId() {
            return awsKeyId;
        }

        @Bean(name = "awsKeySecret")
        public String getAWSKeySecret() {
            return awsKeySecret;
        }

        @Bean(name = "awsRegion")
        public Region getAWSPollyRegion() {
            return Region.getRegion(Regions.fromName(awsRegion));
        }

        @Bean(name = "awsCredentialsProvider")
        public AWSCredentialsProvider getAWSCredentials() {
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.awsKeyId, this.awsKeySecret);
            return new AWSStaticCredentialsProvider(awsCredentials);
        }

        @Bean(name = "awsS3Bucket")
        public String getAWSS3Bucket() {
            return awsS3Bucket;
        }
}
*/
