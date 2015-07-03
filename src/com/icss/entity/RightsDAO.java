package com.icss.entity;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Rights entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.icss.entity.Rights
 * @author MyEclipse Persistence Tools
 */
public class RightsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RightsDAO.class);
	// property constants
	public static final String RIGHTS_NUM = "rightsNum";
	public static final String RIGHTS_NAME = "rightsName";

	protected void initDao() {
		// do nothing
	}

	public void save(Rights transientInstance) {
		log.debug("saving Rights instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Rights persistentInstance) {
		log.debug("deleting Rights instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rights findById(java.lang.Integer id) {
		log.debug("getting Rights instance with id: " + id);
		try {
			Rights instance = (Rights) getHibernateTemplate().get(
					"com.icss.entity.Rights", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Rights instance) {
		log.debug("finding Rights instance by example");
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
		log.debug("finding Rights instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Rights as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRightsNum(Object rightsNum) {
		return findByProperty(RIGHTS_NUM, rightsNum);
	}

	public List findByRightsName(Object rightsName) {
		return findByProperty(RIGHTS_NAME, rightsName);
	}

	public List findAll() {
		log.debug("finding all Rights instances");
		try {
			String queryString = "from Rights";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Rights merge(Rights detachedInstance) {
		log.debug("merging Rights instance");
		try {
			Rights result = (Rights) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Rights instance) {
		log.debug("attaching dirty Rights instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rights instance) {
		log.debug("attaching clean Rights instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RightsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RightsDAO) ctx.getBean("RightsDAO");
	}
}