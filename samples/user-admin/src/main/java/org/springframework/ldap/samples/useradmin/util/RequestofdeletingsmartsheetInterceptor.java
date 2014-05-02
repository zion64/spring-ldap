package org.springframework.ldap.samples.useradmin.util;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tpmlogis.bss.domain.isc.Requestofdeletingsmartsheet;
import com.tpmlogis.bss.mvc.isc.ISCHomeController;

public class RequestofdeletingsmartsheetInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4919199432989302696L;

	private static final Logger logger = LoggerFactory.getLogger(ISCHomeController.class);

	private int updates;
	private int creates;
	private int loads;

	public void onDelete(Object entity,	Serializable id, Object[] state,	String[] propertyNames,	Type[] types) {
		// do nothing
	}

	public boolean onFlushDirty(Object entity, Serializable id,	Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		if (entity instanceof Requestofdeletingsmartsheet) {
			updates++;
			for (int i = 0; i < propertyNames.length; i++) {
				if ("modifieddate".equals(propertyNames[i])) {
					currentState[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public boolean onLoad(Object entity,Serializable id,Object[] state,	String[] propertyNames,	Type[] types) {
		if (entity instanceof Requestofdeletingsmartsheet) {
			loads++;
		}
		return false;
	}

	public boolean onSave(Object entity,Serializable id,Object[] state,	String[] propertyNames,	Type[] types) {

		if (entity instanceof Requestofdeletingsmartsheet) {
			creates++;
			for (int i = 0; i < propertyNames.length; i++) {
				if ("modifieddate".equals(propertyNames[i])) {
					state[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public void afterTransactionCompletion(Transaction tx) {
		if (tx.wasCommitted()) {
			logger.info("Creations: {}, Updates: {}, Loads: {}", creates, updates, loads);
		}
		updates = 0;
		creates = 0;
		loads = 0;
	}
}
