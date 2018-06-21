package org.yeleia.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		System.getProperties().put("projectName","springApp");
		SpringApplication.run(RedisApplication.class, args);
	}
}
