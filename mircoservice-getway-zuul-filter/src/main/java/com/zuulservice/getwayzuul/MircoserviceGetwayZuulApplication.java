package com.zuulservice.getwayzuul;

import com.zuulservice.getwayzuul.filter.PreRequestLogFliter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MircoserviceGetwayZuulApplication {

	@Bean
	public PreRequestLogFliter preRequestLogFliter() {
		return  new PreRequestLogFliter();
	}

	public static void main(String[] args) {
		SpringApplication.run(MircoserviceGetwayZuulApplication.class, args);
	}
}
