package com.icss.service;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.entity.RoleDAO;
import com.icss.entity.UserDAO;
import com.icss.entity.ZyXfmainhisDAO;
import com.icss.model.MDayAnalysis;
import com.icss.model.PieData;
import com.icss.util.PageBean;
import com.icss.util.PageService;

/**
 * 报表业务处理类
 * @author 林玉生
 *
 */
@Service
public class ReportService {
	
	@Autowired
	private ZyXfmainhisDAO zyXfmainhisDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	
	/**
	 * 本店客流量分析（按每小时）
	 * @return
	 */
	public int[] hourkll(String datetime,String shopName) {
		String selectHql = "SELECT  HOUR(fdatetime),sum(frs) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) = '"+datetime+"' AND fmd = '"+shopName+"' GROUP BY HOUR(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, null, zyXfmainhisDAO);
		int[] array = new int[24];
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Integer hours = (Integer) row[0];	//小时 
			Long kll = (Long) row[1];			//客流量
			array[hours] = kll.intValue();		//设置对应小时的客流量,无小时的默认为0
		}
		return array;
	}
	/**
	 * 查询一个分店的客流量 （按每天）
	 * @return
	 */
	public Map<String, Object> daykll(String startTime,String endTime,String shopName) {
		String selectHql = "SELECT  DATE(fdatetime),sum(frs) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) BETWEEN '"+startTime+"' and '"+endTime+"' and fmd ='"+shopName+"' GROUP BY DATE(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, null, zyXfmainhisDAO);
		String[] date_array = new String[list.size()];
		int[] kll_array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Date one = (Date) row[0];
			Long two = (Long)row[1];
			Format f = new SimpleDateFormat("MM.dd");
			date_array[i] = f.format(one);	//日期
			kll_array[i] = two.intValue();	//客流量
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date_array", date_array);
		map.put("kll_array", kll_array);
		return map;
	}
	/**
	 * 分店营业日对比表
	 * @return
	 */
	public List<MDayAnalysis> dayAnalysis(String startTime,String endTime,String shopName,PageBean pageBean) {
		//拼接sql
		String selectHql ="SELECT fmd,DATE(fdatetime),SUM(fxfje),SUM(fzkje),SUM(fzdje),SUM(fxfje-fzkje),SUM(frs),SUM(fxfje)/frs,SUM(fstate) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) BETWEEN '"+startTime+"' and '"+endTime+"' and fmd = '"+shopName+"' ";
		selectHql += "GROUP BY DATE(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, pageBean, zyXfmainhisDAO);
		//初始化数据
		List<MDayAnalysis> mList = new ArrayList<MDayAnalysis>();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			MDayAnalysis mDayAnalysis = new MDayAnalysis();
			mDayAnalysis.setFmd((String) row[0]);
			Format f = new SimpleDateFormat("yyyy-MM-dd");
			String date = f.format((Date)row[1]);	//日期
			mDayAnalysis.setDate(date);
			mDayAnalysis.setSaleAmount(((Double)row[2]));
			mDayAnalysis.setDiscount(((Double)row[3]));
			mDayAnalysis.setRewards(((Double)row[4]));
			mDayAnalysis.setSaleFinal(((Double)row[5]));
			mDayAnalysis.setPassengerFolw(((Long)row[6]));
			if (row[7] == null) {
				mDayAnalysis.setAvgAccount(0);
			}else {
				mDayAnalysis.setAvgAccount(((Double)row[7]));
			}
			mDayAnalysis.setBillAcount(((String)row[8]));
			mList.add(mDayAnalysis);
		}
		return mList;
	}
	/**
	 * 分店营业月对比表
	 * @return
	 */
	public List<MDayAnalysis> monthAnalysis(String datetime,String shopName,PageBean pageBean) {
		//拼接sql
		String selectHql ="SELECT fmd,MONTH(fdatetime),SUM(fxfje),SUM(fzkje),SUM(fzdje),SUM(fxfje-fzkje),SUM(frs),SUM(fxfje)/frs,SUM(fstate) ";
		selectHql += "FROM ZyXfmainhis WHERE YEAR(fdatetime) = '"+datetime+"' and fmd = '"+shopName+"' ";
		selectHql += "GROUP BY MONTH(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, pageBean, zyXfmainhisDAO);
		//初始化数据
		List<MDayAnalysis> mList = new ArrayList<MDayAnalysis>();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			MDayAnalysis mDayAnalysis = new MDayAnalysis();
			mDayAnalysis.setFmd((String) row[0]);
			mDayAnalysis.setDate((Integer)row[1]+"");
			mDayAnalysis.setSaleAmount(((Double)row[2]));
			mDayAnalysis.setDiscount(((Double)row[3]));
			mDayAnalysis.setRewards(((Double)row[4]));
			mDayAnalysis.setSaleFinal(((Double)row[5]));
			mDayAnalysis.setPassengerFolw(((Long)row[6]));
			if (row[7] == null) {
				mDayAnalysis.setAvgAccount(0);
			}else {
				mDayAnalysis.setAvgAccount(((Double)row[7]));
			}
			mDayAnalysis.setBillAcount(((String)row[8]));
			mList.add(mDayAnalysis);
		}
		return mList;
	}
	/**
	 * 营业时段分析表 
	 * @return
	 */
	public List<MDayAnalysis> workAnalysis(String datetime,String shopName,PageBean pageBean) {
		//拼接sql
		String selectHql ="SELECT fmd,HOUR(fdatetime),SUM(fxfje),SUM(fzkje),SUM(fzdje),SUM(fxfje-fzkje),SUM(frs),SUM(fxfje)/frs,SUM(fstate) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) = '"+datetime+"' and fmd = '"+shopName+"' ";
		selectHql += "GROUP BY HOUR(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, pageBean, zyXfmainhisDAO);
		//初始化数据
		List<MDayAnalysis> mList = new ArrayList<MDayAnalysis>();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			MDayAnalysis mDayAnalysis = new MDayAnalysis();
			mDayAnalysis.setFmd((String) row[0]);
			mDayAnalysis.setDate((Integer)row[1]+"");
			mDayAnalysis.setSaleAmount(((Double)row[2]));
			mDayAnalysis.setDiscount(((Double)row[3]));
			mDayAnalysis.setRewards(((Double)row[4]));
			mDayAnalysis.setSaleFinal(((Double)row[5]));
			mDayAnalysis.setPassengerFolw(((Long)row[6]));
			if (row[7] == null) {
				mDayAnalysis.setAvgAccount(0);
			}else {
				mDayAnalysis.setAvgAccount(((Double)row[7]));
			}
			mDayAnalysis.setBillAcount(((String)row[8]));
			mList.add(mDayAnalysis);
		}
		return mList;
	}
	/**
	 * 本店营业额对比分析（按每天）
	 * @return
	 */
	public Map<String, Object> yye(String startTime,String endTime,String shopName) {
		String selectHql = "SELECT  DATE(fdatetime),sum(fxfje) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) BETWEEN '"+startTime+"' and '"+endTime+"' and fmd ='"+shopName+"' GROUP BY DATE(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, null, zyXfmainhisDAO);
		String[] date_array = new String[list.size()];
		double[] kll_array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Date one = (Date) row[0];
			Double two = (Double)row[1];
			Format f = new SimpleDateFormat("MM.dd");
			date_array[i] = f.format(one);	//日期
			kll_array[i] = two;				//营业额
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date_array", date_array);
		map.put("kll_array", kll_array);
		return map;
	}
	/**
	 * 本店会员消费对比分析（按每天）
	 * @return
	 */
	public Map<String, Object> hyxf(String startTime,String endTime,String shopName) {
		String selectHql = "SELECT  DATE(fdatetime),sum(fhykje) ";
		selectHql += "FROM ZyXfmainhis WHERE DATE(fdatetime) BETWEEN '"+startTime+"' and '"+endTime+"' and fmd ='"+shopName+"' GROUP BY DATE(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, null, zyXfmainhisDAO);
		String[] date_array = new String[list.size()];
		double[] kll_array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Date one = (Date) row[0];
			Double two = (Double)row[1];
			Format f = new SimpleDateFormat("MM.dd");
			date_array[i] = f.format(one);	//日期
			kll_array[i] = two;				//营业额
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date_array", date_array);
		map.put("kll_array", kll_array);
		return map;
	}
	/**
	 * 本店消费单对比分析
	 * @return
	 */
	public Map<String, Object> xfd(String startTime,String endTime,String shopName) {
		String selectHql = "SELECT  DATE(fdatetime),sum(fcount) ";
		selectHql += "FROM ZyXfclienthis WHERE DATE(fdatetime) BETWEEN '"+startTime+"' and '"+endTime+"' and fmd ='"+shopName+"' GROUP BY DATE(fdatetime)";
		List list = PageService.searchByPage(selectHql, null, null, null, zyXfmainhisDAO);
		String[] date_array = new String[list.size()];
		double[] kll_array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Date one = (Date) row[0];
			Double two = (Double)row[1];
			Format f = new SimpleDateFormat("MM.dd");
			date_array[i] = f.format(one);	//日期
			kll_array[i] = two;				//营业额
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date_array", date_array);
		map.put("kll_array", kll_array);
		return map;
	}
	/**
	 * 统计系统角色
	 * @return
	 */
	public Map<String, Object> roleAnalysis() {
		String selectHql = "SELECT role.roleId,COUNT(*) from User GROUP BY role.roleId";
		List list = PageService.searchByPage(selectHql, null, null, null, userDAO);
		String[] roleNames = new String[list.size()];
		List<PieData> data = new ArrayList<PieData>();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i); 
			Integer roleId = (Integer) row[0];
			String roleName = roleDAO.findById(roleId).getRoleName();
			Long count = (Long) row[1];
			roleNames[i] = roleName;
			PieData p = new PieData();
			p.setName(roleName);
			p.setValue(count);
			data.add(p);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleNames", roleNames);
		map.put("data", data);
		return map;
	}
	
	
}
