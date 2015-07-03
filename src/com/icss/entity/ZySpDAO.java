package com.icss.entity;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for ZySp
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.icss.entity.ZySp
 * @author MyEclipse Persistence Tools
 */
public class ZySpDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ZySpDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(ZySp transientInstance) {
		log.debug("saving ZySp instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ZySp persistentInstance) {
		log.debug("deleting ZySp instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZySp findById(com.icss.entity.ZySpId id) {
		log.debug("getting ZySp instance with id: " + id);
		try {
			ZySp instance = (ZySp) getHibernateTemplate().get(
					"com.icss.entity.ZySp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ZySp instance) {
		log.debug("finding ZySp instance by example");
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
		log.debug("finding ZySp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ZySp as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all ZySp instances");
		try {
			String queryString = "from ZySp";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ZySp merge(ZySp detachedInstance) {
		log.debug("merging ZySp instance");
		try {
			ZySp result = (ZySp) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ZySp instance) {
		log.debug("attaching dirty ZySp instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZySp instance) {
		log.debug("attaching clean ZySp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ZySpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ZySpDAO) ctx.getBean("ZySpDAO");
	}
}