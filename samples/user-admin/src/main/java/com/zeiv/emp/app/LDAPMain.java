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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		System.out.println("Hi~~~1");
		Session session = sessFact.openSession();
		System.out.println("Hi~~~2");
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class,
					session.createCriteria("com.zeiv.emp.domain.EmployeesAllAttrView").setFirstResult(100).setMaxResults(10).list());
			for(EmployeesAllAttrView view : results) {
				System.out.println(view.getId().getLastName());
			}
		} catch (RuntimeException re) {
			throw re;
		}
		session.close();
		sessFact.close();
	}
}
