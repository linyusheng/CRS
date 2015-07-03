package com.icss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.icss.service.UserService;


/**
 * 权限拦截器
 * 
 * @author 林玉生
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);
	
	private static final String[] IGNORE_URI = {"/login","/loginCombobox","/logout","/register","/isUserNameExist"};

	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 完成页面的render后调用
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)throws Exception {
		System.out.println("afterCompletion...");
	}
	/**
	 * 在调用controller具体方法后拦截
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle...");
	}
	/**
	 * 在调用controller具体方法前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("preHandle...");
		//查出该用户拥有的权限
		Integer userId = (Integer)request.getSession().getAttribute("userId");
		String rightsNum = request.getParameter("rightsNum");
		System.out.println(userId+"/"+rightsNum);
		
//		Set set = userService.get(userId).getRightses();
//		//判断是否拥有该权限
//		for (Object object2 : set) {
//			
//		}
		
		//拦截到登录页面
		//response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		return true;
	}

}
