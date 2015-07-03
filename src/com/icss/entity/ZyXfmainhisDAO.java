package com.icss.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ZyXfmainhis entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.icss.entity.ZyXfmainhis
 * @author MyEclipse Persistence Tools
 */
public class ZyXfmainhisDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ZyXfmainhisDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public static ZyXfmainhisDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ZyXfmainhisDAO) ctx.getBean("ZyXfmainhisDAO");
	}
}