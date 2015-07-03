package com.icss.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.entity.User;
import com.icss.model.DataGrid;
import com.icss.model.Json;
import com.icss.model.MUser;
import com.icss.model.Page;
import com.icss.service.UserService;
import com.icss.util.PageBean;
import com.icss.util.Tool;

/**
 * 用户访问控制类
 * 
 * @author 林玉生
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping("/login")
	public boolean login(User user,HttpSession session){
		User u = userService.login(user.getAccount(), user.getPassword());
		if (u != null) {
			session.setAttribute("userId", u.getUserId());
			session.setAttribute("account", u.getAccount());
			session.setAttribute("userName", u.getUserName());
			session.setAttribute("roleName", u.getRole().getRoleName());
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 退出登录
	 * 
	 * @param session
	 * 
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login";
	}
	/**
	 * 获取用户列表
	 * @param page：EasyUI自动构造好传给后台
	 * @return DataGrid对象
	 */
	@ResponseBody
	@RequestMapping("/datagrid")
	public DataGrid dataGrid(Page page) {
		DataGrid dataGrid = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(page.getRows());
		pageBean.setCurrentPage(page.getPage());
		List<User> list = userService.dataGrid(pageBean,page.getSort(),page.getOrder());
		//对list进行属性转换
		List<MUser> mList = new ArrayList<MUser>();
		String[] ignoreProperties = {"createTime"};
		for (User user : list) {
			MUser mUser = new MUser();
			BeanUtils.copyProperties(user, mUser,ignoreProperties);
			mUser.setRoleName(user.getRole().getRoleName());
			mUser.setCreateTime(Tool.timestampToString(user.getCreateTime()));
			mList.add(mUser);
		}
		dataGrid.setRows(mList);
		dataGrid.setTotal(Long.valueOf(pageBean.getTotalRow()+""));
		return dataGrid;
	}
	/**
	 * 新增或修改用户
	 * 
	 * @param userDataGrid
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Json addOrUpdate(MUser mUser) {
		Json json = new Json();
		User user = new User();
		String[] ignores = {"createTime"};
		//如果userId为空，则新增用户,否则修改用户信息
		if(mUser.getUserId() == null){
			BeanUtils.copyProperties(mUser, user, ignores);
			user.setCreateTime(Tool.getCurrentTime());
			userService.save(user);
			json.setMsg("添加成功！");
		}else {
			user = userService.get(mUser.getUserId());
			BeanUtils.copyProperties(mUser, user, ignores);
			user.setCreateTime(Timestamp.valueOf(mUser.getCreateTime()));
			userService.save(user);
			json.setMsg("修改成功！");
		}
		return json;
	}
	/**
	 * 删除用户
	 * 
	 * @param ids
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public boolean delete(String ids) {
		String[] str = ids.split(",");
		for (String id : str) {
			userService.delete(Integer.valueOf(id));
		}
		return true;
	}
	/**
	 * 是否存在此用户名
	 */
	@ResponseBody
	@RequestMapping("/isUserNameExist")
	public Json isUserNameExist(String userName) {
		Json j = new Json();
		if (userService.isUserNameExist(userName)) {
			j.setMsg("用户名已存在！");
			j.setSuccess(true);
		}else {
			j.setMsg("该用户名可用！");
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/editPassword")
	public String editPassword(String oldPwd,String pwd,HttpSession session) {
		Integer userId = (Integer)session.getAttribute("userId");
		userService.savePassword(userId,oldPwd,pwd);
		return "login";
	}
	/**
	 * 获取用户个人信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request, Integer id) {
		User user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userInfo";
	}
	
}
