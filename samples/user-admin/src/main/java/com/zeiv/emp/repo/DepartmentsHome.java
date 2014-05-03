package com.zeiv.emp.repo;

// Generated 2014. 5. 3 오후 9:29:19 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.samples.useradmin.util.GenericUtil;

import com.zeiv.emp.domain.Departments;

/**
 * Home object for domain model class Departments.
 * @see com.zeiv.emp.domain.Departments
 * @author Hibernate Tools
 */
public class DepartmentsHome {

	private static final Logger		log				= LoggerFactory.getLogger(DepartmentsHome.class);

	private final SessionFactory	sessionFactory	= getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Departments transientInstance) {
		log.debug("persisting Departments instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Departments instance) {
		log.debug("attaching dirty Departments instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Departments instance) {
		log.debug("attaching clean Departments instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Departments persistentInstance) {
		log.debug("deleting Departments instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Departments merge(Departments detachedInstance) {
		log.debug("merging Departments instance");
		try {
			Departments result = (Departments) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Departments findById(java.lang.String id) {
		log.debug("getting Departments instance with id: " + id);
		try {
			Departments instance = (Departments) sessionFactory.getCurrentSession()
					.get("com.zeiv.emp.domain.Departments", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			}
			else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Departments> findByExample(Departments instance) {
		log.debug("finding Departments instance by example");
		try {
			List<Departments> results = GenericUtil.castList(Departments.class, sessionFactory.getCurrentSession()
					.createCriteria("com.zeiv.emp.domain.Departments")
					.add(Example.create(instance))
					.list());
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
