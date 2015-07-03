package com.icss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.entity.Role;
import com.icss.entity.RoleDAO;
import com.icss.util.PageBean;
import com.icss.util.PageService;

@Service
public class RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * 根据主键ID查找对象
	 */
	public Role get(Integer id){
		return roleDAO.findById(id);
	}
	/**
	 * 执行新增对象或修改对象的保存操作
	 */
	public void save(Role role) {
		 roleDAO.merge(role);
	}
	/**
	 * 根据主键ID删除数据库中对象
	 */
	public void delete(Integer id) {
		roleDAO.delete(roleDAO.findById(id));
	}
	/**
	 * 获取角色列表
	 * @param pageBean
	 * @param sort
	 * @param order
	 * @return 
	 */
	public List<Role> dataGrid(PageBean pageBean,String sort,String order) {
		String selectHql = "from Role";
		if (sort != null && order != null) {
			selectHql += " order by " + sort + " " + order;
		}
		String countHql="select count(*) "+selectHql;
		List<Role> list = PageService.searchByPage(selectHql, countHql, null, pageBean, roleDAO);
		return list;
	}
	
}
