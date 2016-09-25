package com.codepandablog.java.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProjectNameController {

	@Value("${projectName}")
	private String projectName;
	
	@RequestMapping("/")
	public String hello(){
		return "hello config";
	}
	
	@RequestMapping("/project-name")
	public String returnProjectName(){
		return this.projectName;
	}
}
