package com.zeiv.emp.app;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.ldap.LdapName;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.samples.useradmin.domain.User;
import org.springframework.ldap.samples.useradmin.service.UserService;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.ldap.test.LdapTestUtils;

import com.google.common.collect.Lists;
import com.zeiv.emp.domain.EmployeesAllAttrView;
import com.zeiv.emp.repo.EmployeesAllAttrViewHome;

public class App {

	private static User getUserFromEmployeesAllAttrView(EmployeesAllAttrView emp) {
		User user = new User();

		String cn = String.format("(%08d)%s %s", emp.getEmpNo(), emp.getFirstName(), emp.getLastName());

		user.setFullName(cn);
		user.setEmployeeNumber(emp.getEmpNo());
		user.setFirstName(emp.getFirstName());
		user.setLastName(emp.getLastName());
		user.setTitle(emp.getTitle());
		user.setEmail("admin@zeiv.dsmynas.com");
		user.setPhone("+82 010 2838 5005");
		user.setDepartment(emp.getDeptNo());

		user.setUid(String.format("%08d", emp.getEmpNo()));
		user.setDescription("N/A");
		user.setDisplayName(emp.getFirstName() + " " + emp.getLastName());
		user.setMobile("010 2838 5005");
		user.setPostalAddress("N/A");
		user.setPostalCode("N/A");
		user.setUserPassword(String.format("%08d", emp.getEmpNo()));
		return user;
	}

	private static void listViewOfemployeesAllAttrViews(ConfigurableApplicationContext context) throws NamingException {

		EmployeesAllAttrViewHome employeesAllAttrViewHome = (EmployeesAllAttrViewHome) context.getBean("employeesAllAttrViewHome");

		UserService userService = (UserService) context.getBean("userService");

		ContextSource contextSource = (ContextSource) context.getBean("contextSource");
		for (int oud = 1; oud < 10; oud++) {
			String dn = String.format("ou=d%03d,ou=Departments", oud);
			LdapName name = new LdapName(dn);
			LdapTestUtils.clearSubContexts(contextSource, name);
			System.out.println(dn + " 하위 엔트리를 삭제했습니다.");
		}

		try {
			List<EmployeesAllAttrView> results =
					employeesAllAttrViewHome.findAll();
			String header =
					String.format("%-8s%-15s%-15s%-8s%-30s%-6s%-13s%-13s%-13s%-13s%-13s%-13s"
							, "EmpNo", "FirstName", "lastName", "DeptNo", "Title", "Gender",
							"HireDate", "BirthDate", "DeptFromDate", "DeptToDate",
							"TitleFromDate", "TitleToDate");

			System.out.println(header);

			for (EmployeesAllAttrView view : results) {
				String data =
						String.format
								("%08d%-15s%-15s%-8s%-30s%-6s%-13s%-13s%-13s%-13s%-13s%-13s",
										view.getEmpNo(), view.getFirstName(), view.getLastName(),
										view.getDeptNo(), view.getTitle(), view.getGender(),
										view.getHireDate(), view.getBirthDate(), view.getDeptFromDate(),
										view.getDeptToDate(), view.getTitleFromDate(),
										view.getTitleToDate());
				System.out.println(data);

				User user = getUserFromEmployeesAllAttrView(view);

				userService.createUser(user);
			}
		} catch (RuntimeException re) {
			throw re;
		}

	}

	@SuppressWarnings("unused")
	private static void listAllUsersFromLDAP(ConfigurableApplicationContext context) {
		UserService us = (UserService) context.getBean("userService");
		List<User> results = Lists.newArrayList(us.findAll().iterator());
		for (User user : results) {
			String data = String.format("%-5d%-10s%-20s%-30s%-30s", user.getEmployeeNumber(), user.getFirstName(), user.getLastName(),
					user.getFullName(), user.getEmail());
			System.out.println(data);
		}
	}

	public static void main(String[] args) throws NamingException {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] { "classpath:/META-INF/spring-context/ldap-context.xml",
						"classpath:/META-INF/spring-context/orm-context.xml" });

		listViewOfemployeesAllAttrViews(context);
		// listAllUsersFromLDAP(context);

		context.close();
	}
}
