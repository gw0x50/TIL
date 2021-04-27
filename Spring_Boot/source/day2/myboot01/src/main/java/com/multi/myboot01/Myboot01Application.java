package com.multi.myboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring_mybatis.EmpController;
import spring_mybatis.EmpDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = EmpController.class)
@MapperScan(basePackageClasses = EmpDAO.class)
public class Myboot01Application {

	public static void main(String[] args) {
		// spring boot tomcat 내장 서버 자동 실행
		SpringApplication.run(Myboot01Application.class, args);
	}

}
