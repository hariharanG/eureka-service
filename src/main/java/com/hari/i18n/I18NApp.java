package com.hari.i18n;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class I18NApp {

	public static void main(String... args) {
		//Please do not run since we have user server.port as 8761 in application.properties
		
		// System.setProperty("server.servlet.context-path", "/i18n");
		// SpringApplication.run(I18NApp.class, args);
		
		SpringApplication app = new SpringApplication(I18NApp.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", 9090));
		app.run(args);
		System.out.println("App runs on port 9090; i-e: http://localhost:9090/");
		
	}

}
