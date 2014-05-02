package org.springframework.ldap.samples.useradmin.util;

import javax.naming.InitialContext;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HbUtil {

	private static final Logger log = LoggerFactory.getLogger(HbUtil.class);

	@SuppressWarnings("unused")
	private static SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	private static ServiceRegistry serviceRegistry;

	public static <T> SessionFactory getSessionFactory(Class<T> cls) {
		log.info("로그(" + cls.getName() + ") : JNDI에서 세션 팩토리를 가져옵니다.");
		SessionFactory sf;
		InitialContext ic;
		try {
			ic = new InitialContext();
			sf = (SessionFactory) ic.lookup("java:jboss/hibernate/classicmodelsSessionFactory");
			return sf;
		} catch (Exception e) {
			log.error("로그 : JNDI 내에서 세션팩토리를 찾을 수 없습니다.\n\n{}\n\n\n\n\n", e.getMessage());
			throw new IllegalStateException("익셉션 : JNDI 내에서 세션팩토리를 찾을 수 없습니다");
		}
	}

	public static <T> SessionFactory getSessionFactory(String jndi, Class<T> cls) {
		log.info("로그(" + cls.getName() + ") : JNDI에서 세션 팩토리를 가져옵니다.");
		SessionFactory sf;
		InitialContext ic;
		try {
			ic = new InitialContext();
			sf = (SessionFactory) ic.lookup(jndi);

			return sf;
		} catch (Exception e) {
			log.error("로그 : JNDI 내에서 세션팩토리를 찾을 수 없습니다.\n\n{}\n\n\n\n\n", e.getMessage());
			throw new IllegalStateException("익셉션 : JNDI 내에서 세션팩토리를 찾을 수 없습니다");
		}
	}

//	@SuppressWarnings("deprecation")
//	private static SessionFactory buildSessionFactory() {
//		Configuration configuration = new Configuration().setInterceptor(new MyInterceptor());
//		configuration.configure();
//		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).getBootstrapServiceRegistry();
//		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		return sessionFactory;
//	}

	// private static <T> SessionFactory configureSessionFactory(Class<T> cls)
	// throws HibernateException {
	// Configuration configuration = new Configuration();
	// configuration.configure();
	// serviceRegistry = new
	// StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// return sessionFactory;
	// }
	//
	// public static <T> SessionFactory getSessionFactory(Class<T> cls) {
	// return configureSessionFactory(cls);
	//
	// }
}
