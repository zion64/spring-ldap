package com.zeiv.emp.app;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zeiv.emp.domain.EmployeesAllAttrView;
import com.zeiv.emp.repo.EmployeesAllAttrViewHome;

public class App {

	public static void main(String[] args) {
    	ConfigurableApplicationContext context = 
		new ClassPathXmlApplicationContext(new String[] {"classpath:/META-INF/spring-context/ldap-context.xml", 
														 "classpath:/META-INF/spring-context/orm-context.xml"});

    	EmployeesAllAttrViewHome employeesAllAttrViewHome = (EmployeesAllAttrViewHome)context.getBean("employeesAllAttrViewHome");
    	
		try {
			List<EmployeesAllAttrView> results = employeesAllAttrViewHome.findAll(0, 500);
			String header = String.format("%-8s%-15s%-20s%-6s%-20s%-6s%-13s%-13s%-13s%-13s%-13s%-13s", "EmpNo", "FirstName", "lastName", "DeptNo", "Title", "Gender", "HireDate",
					"BirthDate", "DeptFromDate", "DeptToDate", "TitleFromDate", "TitleToDate");
			System.out.println(header);
			for(EmployeesAllAttrView view : results) {
				String data = String.format("%-8s%-15s%-20s%-6s%-20s%-6s%-13s%-13s%-13s%-13s%-13s%-13s", view.getEmpNo(), view.getFirstName(), view.getLastName(), 
						view.getDeptNo(), view.getTitle(), view.getGender(), view.getHireDate(), view.getBirthDate(), view.getDeptFromDate(), view.getDeptToDate(), 
						view.getTitleFromDate(), view.getTitleToDate());
				System.out.println(data);
			}
		} catch (RuntimeException re) {
			throw re;
		}
    	
    	context.close();
	}
}
