package com.icss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.model.DataGrid;
import com.icss.model.MDayAnalysis;
import com.icss.model.Page;
import com.icss.service.ReportService;
import com.icss.util.PageBean;


/**
 * 用户访问控制类
 * 
 * @author 林玉生
 */
@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	/**
	 * 本店客流量对比表（按每小时） 分店客流量对比表 （按每天）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hourkll")
	public int[] hourkll(String datetime,String shopName) {
		int[] array = reportService.hourkll(datetime,shopName);
		return array;
	}
	/**
	 * 分店客流量对比表 （按每天）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/daykll")
	public Map<String, Object> daykll(String startTime,String endTime,String names) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] shopNames =names.split(",");
		Object[] result = new Object[shopNames.length];
		for (int i = 0; i < shopNames.length; i++) {
			String shopName = shopNames[i];
			Map<String, Object> temp = reportService.daykll(startTime,endTime,shopName);
			result[i] = temp.get("kll_array");
		}
		
		map.put("date_array", reportService.daykll(startTime,endTime,shopNames[0]).get("date_array"));
		map.put("kll_array", result);
		return map;
	}
	/**
	 * 分店营业日对比表
	 * @param page
	 * @param startTime
	 * @param endTime
	 * @param shopName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dayAnalysis")
	public DataGrid dayAnalysis(Page page,String startTime,String endTime,String shopName) {
		//System.out.println(startTime+endTime+shopName);
		DataGrid dataGrid = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(page.getRows());
		pageBean.setCurrentPage(page.getPage());
		List<MDayAnalysis> list = reportService.dayAnalysis(startTime, endTime, shopName, pageBean);
		dataGrid.setRows(list);
		dataGrid.setTotal(Long.valueOf(pageBean.getTotalRow()+""));
		return dataGrid;
	}
	/**
	 * 分店营业月对比表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/monthAnalysis")
	public DataGrid monthAnalysis(Page page,String datetime,String shopName) {
		DataGrid dataGrid = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(page.getRows());
		pageBean.setCurrentPage(page.getPage());
		datetime = "2014";
		List<MDayAnalysis> list = reportService.monthAnalysis(datetime, shopName, pageBean);
		dataGrid.setRows(list);
		dataGrid.setTotal(Long.valueOf(pageBean.getTotalRow()+""));
		return dataGrid;
	}
	/**
	 * 营业时段分析表 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/workAnalysis")
	public DataGrid workAnalysis(Page page,String datetime,String shopName) {
		DataGrid dataGrid = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(page.getRows());
		pageBean.setCurrentPage(page.getPage());
		List<MDayAnalysis> list = reportService.workAnalysis(datetime, shopName, pageBean);
		dataGrid.setRows(list);
		dataGrid.setTotal(Long.valueOf(pageBean.getTotalRow()+""));
		return dataGrid;
	}
	/**
	 * 本店营业额对比分析（按每天）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/yye")
	public Map<String, Object> yye(String startTime,String endTime,String shopName) {
		Map<String, Object> map = reportService.yye(startTime,endTime,shopName);
		return map;
	}
	/**
	 * 本店会员消费对比分析（按每天）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hyxf")
	public Map<String, Object> hyxf(String startTime,String endTime,String shopName) {
		Map<String, Object> map = reportService.hyxf(startTime,endTime,shopName);
		return map;
	}
	/**
	 * 本店消费单对比分析
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/xfd")
	public Map<String, Object> xfd(String startTime,String endTime,String shopName) {
		Map<String, Object> map = reportService.xfd(startTime,endTime,shopName);
		return map;
	}
	/**
	 * 统计系统角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/analysisRole")
	public Map<String, Object> roleAnalysis() {
		return reportService.roleAnalysis();
	}
	
}
