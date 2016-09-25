package com.codepandablog.java.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("Setting Project Name: " + projectName);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("Setting environment: " + env.getProperty("configuration.projectName"));
	}
	
	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties cp){
		System.out.println("ConfigurationProjectProperties.getProjectName: "+cp.getProjectName());
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
}

@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties{
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	//here we can have JSR 303 validation annotations
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}