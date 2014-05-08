package com.zeiv.emp.repo;

// Generated 2014. 5. 4 오전 12:22:02 by Hibernate Tools 4.0.0

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.samples.useradmin.util.GenericUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zeiv.emp.domain.EmployeesAllAttrView;

/**
 * Home object for domain model class EmployeesAllAttrView.
 * @see com.zeiv.emp.util.EmployeesAllAttrView
 * @author Hibernate Tools
 */
@Repository(value="employeesAllAttrViewHome")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmployeesAllAttrViewHome {

	private static final Logger		log				= LoggerFactory.getLogger(EmployeesAllAttrViewHome.class);

	@Autowired
	private SessionFactory	sessionFactory;

	public void persist(EmployeesAllAttrView transientInstance) {
		log.debug("persisting EmployeesAllAttrView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EmployeesAllAttrView instance) {
		log.debug("attaching dirty EmployeesAllAttrView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(EmployeesAllAttrView instance) {
		log.debug("attaching clean EmployeesAllAttrView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EmployeesAllAttrView persistentInstance) {
		log.debug("deleting EmployeesAllAttrView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmployeesAllAttrView merge(EmployeesAllAttrView detachedInstance) {
		log.debug("merging EmployeesAllAttrView instance");
		try {
			EmployeesAllAttrView result = (EmployeesAllAttrView) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeesAllAttrView findById(int id) {
		log.debug("getting EmployeesAllAttrView instance with id: " + id);
		try {
			EmployeesAllAttrView instance = (EmployeesAllAttrView) sessionFactory.getCurrentSession()
					.get("com.zeiv.emp.domain.EmployeesAllAttrView", id);
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

	public List<EmployeesAllAttrView> findByExample(EmployeesAllAttrView instance) {
		log.debug("finding EmployeesAllAttrView instance by example");
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class, sessionFactory.getCurrentSession()
					.createCriteria("com.zeiv.emp.util.EmployeesAllAttrView")
					.add(Example.create(instance))
					.list());
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<EmployeesAllAttrView> findAll(int start, int limit) {
		log.debug("finding Employees instance by example");
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class,
					sessionFactory.getCurrentSession().createCriteria("com.zeiv.emp.domain.EmployeesAllAttrView")
							.setFirstResult(start)
							.setMaxResults(limit)
							.list());
			log.info("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Transactional
	public List<EmployeesAllAttrView> findAll() {
		log.info("finding EmployeesAllAttrView instance by findAll");
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class,
					sessionFactory.getCurrentSession().createCriteria("com.zeiv.emp.domain.EmployeesAllAttrView").list());
			log.info("findAll successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("EmployeesAllAttrView failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<EmployeesAllAttrView> findAll(String deptNo) {
		log.info("finding EmployeesAllAttrView instance by findAll");
		try {
			List<EmployeesAllAttrView> results = GenericUtil.castList(EmployeesAllAttrView.class,
					sessionFactory.getCurrentSession().createCriteria("com.zeiv.emp.domain.EmployeesAllAttrView").add(Restrictions.eq("deptNo",deptNo)).list());
			log.info("findAll successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("EmployeesAllAttrView failed", re);
			throw re;
		}
	}
	
	public Number getTotalCountOfEmployeesAllAttrView() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return ((Number) session.createSQLQuery("select count(*) from employees_all_attr_view").uniqueResult()).longValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
	}
}
