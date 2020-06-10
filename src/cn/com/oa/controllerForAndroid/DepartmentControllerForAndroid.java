package cn.com.oa.controllerForAndroid;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.Department;
import cn.com.oa.serviceForAndroid.DepartmentServiceForAndroid;
import net.sf.json.JSONArray;

@RequestMapping("departmentInfo")
@Controller
public class DepartmentControllerForAndroid {
	@Autowired
	private DepartmentServiceForAndroid departmentServiceForAndroid;
	
	 //查询所有一级部门
    @RequestMapping(value="selectFirstDepartment")
    @ResponseBody
    public void selectFirstDepartment(HttpServletResponse response)throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	List<Department> depList = departmentServiceForAndroid.selectFirstDepartment();
    	PrintWriter out = response.getWriter();
    	if (depList!=null && depList.size()>0) {
    		//转换list数组的
    		JSONArray depJSONArray = JSONArray.fromObject(depList);
			out.print(depJSONArray);
		}else {
			out.print("");
		}
    } 
    
  //查询所有二级部门
    @RequestMapping(value="selectSecondDepartment")
    @ResponseBody
    public void selectSecondDepartment(HttpServletResponse response,Integer parentId)throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	List<Department> departmentList = departmentServiceForAndroid.selectSecondDepartment(parentId);
    	PrintWriter out = response.getWriter();
    	if (departmentList!=null && departmentList.size()>0) {
    		//转换list数组的
    		JSONArray departmentJSONArray = JSONArray.fromObject(departmentList);
			out.print(departmentJSONArray);
		}else {
			out.print("");
		}
    } 

}
