package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffDateBase;
import cn.com.oa.pojo.StaffInfo;
import cn.com.oa.pojo.StaffMoreProperty;
import cn.com.oa.service.StaffService;
import cn.com.oa.serviceForAndroid.StaffServiceForAndroid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("staffInfo")
@Controller
public class StaffControllerForAndroid {

    @Autowired
    private StaffServiceForAndroid staffServiceForAndroid;
    @Autowired
    private StaffService staffService;
    
    //验证登录信息
    @RequestMapping(value="/getStaffByNameAndPassword")
    @ResponseBody
    public void getStaffByNameAndPassword(@RequestParam("userName") String userName, @RequestParam("password") String password,
           HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
        StaffMoreProperty staffMoreProperty=staffServiceForAndroid.getStaffByNameAndPassword(userName,password);
        if (staffMoreProperty==null) {
            out.print("");
        }else {
            JSONObject jsonObject = JSONObject.fromObject(staffMoreProperty);
        	out.print(jsonObject);
        }
    }
    
    
    // 查询个人信息
    @RequestMapping(value="/findStaffInfo")
    @ResponseBody
    public void findPersonalInfo(HttpServletResponse response,int sfId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
        StaffInfo sfInfo=staffServiceForAndroid.findStaffById(sfId);
        PrintWriter out = response.getWriter();
        if (sfInfo!=null) {
        	JSONObject jsonObject = JSONObject.fromObject(sfInfo);
        	out.print(jsonObject);
		}else {
			out.print("");
		}
    }
    
 // 根据dpmId查询员工
    @RequestMapping(value="/findStaffByDpmId")
    @ResponseBody
    public void findStaffByDpmId(HttpServletResponse response,int dpmId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
        List<StaffDateBase> staffList=staffServiceForAndroid.findStaffByDpmId(dpmId);
        PrintWriter out = response.getWriter();
    	if (staffList!=null && staffList.size()>0) {
    		//转换list数组的
    		JSONArray depJSONArray = JSONArray.fromObject(staffList);
			out.print(depJSONArray);
		}else {
			out.print("");
		}
    }
    
    
    //查询所有员工
    @RequestMapping(value="selectAllStaff")
    @ResponseBody
    public void selectAllStaff(HttpServletResponse response)throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	List<StaffInfo> staffList = staffServiceForAndroid.selectAllStaff();
    	if (staffList!=null && staffList.size()>0) {
    		PrintWriter out = response.getWriter();
    		//转换list数组的
    		JSONArray androidStaffInfo = JSONArray.fromObject(staffList);
			out.print(androidStaffInfo);
		}else {
//			return null;
		}
    }
    
 // 修改个人密码
    @RequestMapping(value="/updatePasswordById")
    @ResponseBody
    public void updatePasswordById(@RequestParam("sfPassword") String sfPassword,@RequestParam("sfId") int sfId,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
        int flag=staffService.updatePassword(sfPassword,sfId);
        JSONObject jsonObject=new JSONObject();
        PrintWriter out = response.getWriter();
        if(flag>0){
        	jsonObject.element("status", 1);
        	out.print(jsonObject);
        }else{
        	jsonObject.element("status", -1);
        	out.print(jsonObject);
        }
        
    }
    
  //保存修改后的个人性别
    @RequestMapping(value="/updateSex")
    public void updateSex(String sfSex,int sfId,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	int result = staffServiceForAndroid.updateSex(sfSex, sfId);
    	JSONObject jsonObject = new JSONObject();
    	if (result>0) {
			jsonObject.element("status", 1);
			out.print(jsonObject);
		}else {
			jsonObject.element("status", -1);
			out.print(jsonObject);
		}
    }
    
    //保存修改后的个人手机号码
    @RequestMapping(value="/updatePhone")
    public void updatePhone(String sfPhone,int sfId,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	int result = staffServiceForAndroid.updatePhone(sfPhone, sfId);
    	JSONObject jsonObject = new JSONObject();
    	if (result>0) {
			jsonObject.element("status", 1);
			out.print(jsonObject);
		}else {
			jsonObject.element("status", -1);
			out.print(jsonObject);
		}
    }
    
  //保存修改后的个人地址
    @RequestMapping(value="/updateAddress")
    public void updateAddress(String sfAddress,int sfId,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	int result = staffServiceForAndroid.updateAddress(sfAddress, sfId);
    	JSONObject jsonObject = new JSONObject();
    	if (result>0) {
			jsonObject.element("status", 1);
			out.print(jsonObject);
		}else {
			jsonObject.element("status", -1);
			out.print(jsonObject);
		}
    }
    
    //保存修改后的个人邮箱
    @RequestMapping(value="/updateEmail")
    public void updateEmail(String sfEmail,int sfId,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	int result = staffServiceForAndroid.updateEmail(sfEmail, sfId);
    	JSONObject jsonObject = new JSONObject();
    	if (result>0) {
			jsonObject.element("status", 1);
			out.print(jsonObject);
		}else {
			jsonObject.element("status", -1);
			out.print(jsonObject);
		}
    }

    
}
