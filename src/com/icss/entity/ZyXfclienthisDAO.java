package com.icss.entity;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ZyXfclienthis entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.icss.entity.ZyXfclienthis
 * @author MyEclipse Persistence Tools
 */
public class ZyXfclienthisDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ZyXfclienthisDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(ZyXfclienthis transientInstance) {
		log.debug("saving ZyXfclienthis instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ZyXfclienthis persistentInstance) {
		log.debug("deleting ZyXfclienthis instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZyXfclienthis findById(com.icss.entity.ZyXfclienthis id) {
		log.debug("getting ZyXfclienthis instance with id: " + id);
		try {
			ZyXfclienthis instance = (ZyXfclienthis) getHibernateTemplate()
					.get("com.icss.entity.ZyXfclienthis", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ZyXfclienthis instance) {
		log.debug("finding ZyXfclienthis instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ZyXfclienthis instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ZyXfclienthis as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all ZyXfclienthis instances");
		try {
			String queryString = "from ZyXfclienthis";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ZyXfclienthis merge(ZyXfclienthis detachedInstance) {
		log.debug("merging ZyXfclienthis instance");
		try {
			ZyXfclienthis result = (ZyXfclienthis) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ZyXfclienthis instance) {
		log.debug("attaching dirty ZyXfclienthis instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZyXfclienthis instance) {
		log.debug("attaching clean ZyXfclienthis instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ZyXfclienthisDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ZyXfclienthisDAO) ctx.getBean("ZyXfclienthisDAO");
	}
}