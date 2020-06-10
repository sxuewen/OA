package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.StaffSign;
import cn.com.oa.serviceForAndroid.StaffSignServiceForAndroid;
import net.sf.json.JSONObject;

@RequestMapping("staffSignInfo")
@Controller
public class StaffSignControllerForAndroid {
	 @Autowired
	    private StaffSignServiceForAndroid staffSignServiceForAndroid;
	    
	    
	    /**
	     * 保存日、周、月报、会议纪要
	     * @return
	     * @throws IOException 
	     */
	    @RequestMapping("/addStaffSign")
	    public void addStaffSign(String staffSignStr,HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        System.out.println(staffSignStr);
	        JSONObject jo=JSONObject.fromObject(staffSignStr);
	        StaffSign staffSign=(StaffSign)JSONObject.toBean(jo, StaffSign.class);
	        int status=staffSignServiceForAndroid.addStaffSign(staffSign);
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        if(status>0){
//	        	1表示插入成功
	        	jsonObject.element("status", 1);
	        	out.print(jsonObject);
	        }else{
//	        	-1表示插入失败
	        	jsonObject.element("status", -1);
	        	out.print(jsonObject);
	        }    
	    }
	    
	    @RequestMapping("/getWorkCount")
	    public void getWorkCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getWorkCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getRestCount")
	    public void getRestCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getRestCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getLateCount")
	    public void getLateCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getLateCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getBackCount")
	    public void getBackCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getBackCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getLoseCount")
	    public void getLoseCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getLoseCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    
	    @RequestMapping("/getAbsenceCount")
	    public void getAbsenceCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getAbsenceCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getOutsideCount")
	    public void getOutsideCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getOutsideCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	    @RequestMapping("/getAddWorkCount")
	    public void getAddWorkCount(HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        int count=staffSignServiceForAndroid.getAddWorkCount();
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        jsonObject.element("count", count);
	        out.print(jsonObject);
	    }
	    
	   
}
