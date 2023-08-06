package com.marketing.productmarketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // This annotation is used to register the application with the discovery server

public class ProductMarketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMarketingApplication.class, args);
	}

}
