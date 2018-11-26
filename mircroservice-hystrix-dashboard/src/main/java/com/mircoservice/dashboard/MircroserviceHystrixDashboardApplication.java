package com.mircoservice.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MircroserviceHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircroserviceHystrixDashboardApplication.class, args);
	}
}
