/**
 * 
 */
package com.zeiv.emp.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ldap.samples.useradmin.util.GenericUtil;

import com.zeiv.emp.domain.EmployeesAllAttrView;
import com.zeiv.emp.util.HibernateUtil;

/**
 * @author anjongdeog
 *
 */
public class LDAPMain {

	public static void main(String[] args) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.openSession();
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class,
					session.createCriteria("com.zeiv.emp.domain.EmployeesAllAttrView").setFirstResult(0).setMaxResults(100).list());
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
		session.close();
//		sessFact.close();
		
	}
}
