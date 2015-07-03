package com.icss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.entity.User;
import com.icss.entity.UserDAO;
import com.icss.util.PageBean;
import com.icss.util.PageService;

/**
 * 用户业务处理类
 * @author 林玉生
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	/**
	 * 根据主键ID查找对象
	 */
	public User get(Integer id){
		return userDAO.findById(id);
	}
	/**
	 * 执行新增对象或修改对象的保存操作
	 */
	public void save(User user) {
		userDAO.merge(user);
	}
	/**
	 * 根据主键ID删除数据库中对象
	 */
	public void delete(Integer id) {
		userDAO.delete(userDAO.findById(id));
	}
	/**
	 * 是否存在此用户,存在返回true,不存在返回false
	 */
	@SuppressWarnings("unchecked")
	public boolean isUserNameExist(String userName){
		String selectHql ="from User as u where u.userName='"+userName+"'";
		List<User> userList = PageService.searchByPage(selectHql, null, null, null, userDAO);
		if(userList.isEmpty()){
			return false;
		}
		else 
			return true;
	}
	/**
	 * 用户登录验证
	 */
	public User login(String account,String password){
		String selectHql ="from User as u where u.account='"+account+"' and u.password='"+password+"'";
		List<User> userList = PageService.searchByPage(selectHql, null, null, null, userDAO);
		if(userList.isEmpty()){
			return null;
		}
		else 
			return userList.get(0);
	}
	/**
	 * 按条件查询和分页支持
	 * 
	 * 根据用户名执行模糊匹配查找，通过Page对象执行分页。
	 * 
	 * @userName：会员登录账号
	 * 
	 * @page:分页对象
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<User> searchUser(String userName, PageBean page) {
		Object[] params = null;
		//创建HQL查询语句
		String selectHql = null;
		if((userName == null) || (userName.equals(""))) {
			selectHql = "from User";
		} else {
			selectHql = "from User where userName like '%" + userName + "%'";
		}
		
		//创建获取HQL返回记录总行数语句
		String countHql = "select count(*) " + selectHql;
		
		//执行按条件查询和分页支持
		List<User> userList = PageService.searchByPage(selectHql, countHql, params, page, userDAO);
		return userList;
	}
	/**
	 * 根据用户名查找用户
	 */
	@SuppressWarnings("unchecked")
	public List<User> searchUserByUserName(String userName){
		Object[] params=null;
		String selectHql=null;
		selectHql="from User as u where u.userName = '"+userName+"'";
		String countHql="select count(*) "+selectHql;
		List<User> userList=PageService.searchByPage(selectHql, countHql, params, null, userDAO);
		return userList;
	}
	/**
	 * 修改用户密码
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public boolean savePassword(Integer userId,String oldPassword,String newPassword){
		User user=userDAO.findById(userId);
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			userDAO.merge(user);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 获取指定用户信息
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUser(PageBean page,String sort,String order) {
		Object[] params=null;
		String selectHql=null;
		selectHql="from User";
		if (sort != null && order != null) {
			selectHql = selectHql + " order by " + sort + " " + order;
		}
		String countHql="select count(*) "+selectHql;
		List<User> list=PageService.searchByPage(selectHql, countHql, params, page, userDAO);
		return list;
	}
	/**
	 * 获取用户列表
	 * @param pageBean
	 * @param sort
	 * @param order
	 * @return 
	 */
	public List<User> dataGrid(PageBean pageBean,String sort,String order) {
		String selectHql = "from User";
		if (sort != null && order != null) {
			selectHql += " order by " + sort + " " + order;
		}
		String countHql="select count(*) "+selectHql;
		List<User> list = PageService.searchByPage(selectHql, countHql, null, pageBean, userDAO);
		return list;
	}
	
	
	
	
	
	
	
	
}
