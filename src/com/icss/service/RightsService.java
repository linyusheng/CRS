package com.icss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.entity.Rights;
import com.icss.entity.RightsDAO;
import com.icss.util.PageBean;
import com.icss.util.PageService;

@Service
public class RightsService {
	
	@Autowired
	private RightsDAO rightsDAO;
	
	/**
	 * 根据主键ID查找对象
	 */
	public Rights get(Integer id) {
		return rightsDAO.findById(id);
	}
	/**
	 * 执行新增对象的保存操作
	 */
	public void save(Rights rights) {
		rightsDAO.save(rights);
	}
	/**
	 * 根据主键ID删除数据库中对象
	 */
	public void delete(Integer id) {
		rightsDAO.delete(rightsDAO.findById(id));
	}
	/**
	 * 获取权限列表
	 * @param pageBean
	 * @param sort
	 * @param order
	 * @return 
	 */
	public List<Rights> dataGrid(PageBean pageBean,String sort,String order) {
		String selectHql = "from Rights";
		if (sort != null && order != null) {
			selectHql += " order by " + sort + " " + order;
		}
		String countHql="select count(*) "+selectHql;
		List<Rights> list = PageService.searchByPage(selectHql, countHql, null, pageBean, rightsDAO);
		return list;
	}
	
	

}
