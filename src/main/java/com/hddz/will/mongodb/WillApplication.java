package com.hddz.will.mongodb;

// import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
// @EnableAutoConfiguration
// @EnableAdminServer
@SpringBootApplication
public class WillApplication {

	public static void main(String[] args) {
		SpringApplication.run(WillApplication.class, args);
	}

}
