package com.codepandablog.java.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = { "com.codepandablog.java.spring.config", "com.codepandablog.java.spring.controller" })
public class Application {

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("Setting environment:" + env.getProperty("projectName"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * @RestController
 * 
 * @RefreshScope class ProjectNameController {
 * 
 * @Value("${projectName}") private String projectName;
 * 
 * @RequestMapping("/") public String hello(){ return "hello config"; }
 * 
 * @RequestMapping("/project-name") public String returnProjectName(){ return
 * this.projectName; } }
 */