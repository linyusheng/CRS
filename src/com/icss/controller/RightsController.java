package com.icss.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.entity.Rights;
import com.icss.entity.User;
import com.icss.model.DataGrid;
import com.icss.model.Json;
import com.icss.model.MRights;
import com.icss.model.Page;
import com.icss.service.RightsService;
import com.icss.util.PageBean;
import com.icss.util.Tool;


@Controller
@RequestMapping("/rights")
public class RightsController {
	
	@Autowired
	private RightsService rightsService;
	
	/**
	 * 获取权限列表
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
		List<Rights> list = rightsService.dataGrid(pageBean,page.getSort(),page.getOrder());
		//对list进行属性转换
		List<MRights> mList = new ArrayList<MRights>();
		String[] ignoreProperties = {"createTime"};
		for (Rights rights : list) {
			MRights mRights = new MRights();
			BeanUtils.copyProperties(rights, mRights,ignoreProperties);
			mRights.setUserName(rights.getUser().getAccount());
			mRights.setCreateTime(Tool.timestampToString(rights.getCreateTime()));
			mList.add(mRights);
		}
		dataGrid.setRows(mList);
		dataGrid.setTotal(Long.valueOf(pageBean.getTotalRow()+""));
		return dataGrid;
	}
	/**
	 * 新增或修改权限
	 * 
	 * @param mRights
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Json addOrUpdate(MRights mRights) {
		Json json = new Json();
		Rights rights = new Rights();
		String[] ignores = {"createTime"};
		//如果rightsId为空，则新增权限,否则修改权限信息
		if(mRights.getRightsId() == null){
			BeanUtils.copyProperties(mRights, rights, ignores);
			rights.setCreateTime(Tool.getCurrentTime());
			User user = new User();
			user.setAccount(mRights.getUserName());
			rights.setUser(user);
			rightsService.save(rights);
			json.setMsg("添加成功！");
		}else {
			rights = rightsService.get(mRights.getRightsId());
			BeanUtils.copyProperties(mRights, rights, ignores);
			rights.setCreateTime(Timestamp.valueOf(mRights.getCreateTime()));
			User user = new User();
			user.setAccount(mRights.getUserName());
			rights.setUser(user);
			rightsService.save(rights);
			json.setMsg("修改成功！");
		}
		return json;
	}
	/**
	 * 删除权限
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
			rightsService.delete(Integer.valueOf(id));
		}
		return true;
	}

}
