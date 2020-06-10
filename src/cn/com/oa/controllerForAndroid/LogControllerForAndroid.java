package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.DayLog;
import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;
import cn.com.oa.pojo.MeetingLog;
import cn.com.oa.service.LogService;
import cn.com.oa.serviceForAndroid.LogServiceForAndroid;
import cn.com.oa.util.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("logInfo")
@Controller
public class LogControllerForAndroid {

    
    @Autowired
    private LogServiceForAndroid logServiceForAndroid;
    @Autowired
    private LogService logService;
    
    
    /**
     * 保存日、周、月报、会议纪要
     * @return
     * @throws IOException 
     */
    @RequestMapping("/addLog")
    @ResponseBody
    public void addLog(String logStr,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        System.out.println(logStr);
        JSONObject jo=JSONObject.fromObject(logStr);
        Log log=(Log)JSONObject.toBean(jo, Log.class);
        System.out.println(log.getLogContent());
        int status=logServiceForAndroid.addLog(log);
        System.out.println(status);
        JSONObject jsonObject=new JSONObject();
        PrintWriter out = response.getWriter();
        if(status>0){
//        	1表示插入成功
        	jsonObject.element("status", 1);
        	out.print(jsonObject);
        }else{
//        	-1表示插入失败
        	jsonObject.element("status", -1);
        	out.print(jsonObject);
        }    
    }
    
  //安卓端根据日志类型和部门Id查询日志
    @RequestMapping("selectlogBylogType")
    @ResponseBody
    public void selectlogBylogType(HttpServletResponse response,int logType,int  dpmId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	List<LogVo> logVoList = logServiceForAndroid.selectlogBylogTypeForAndroid(logType, dpmId);
    	if (logVoList!=null && logVoList.size()>0) {
			JSONArray jsonArray = JSONArray.fromObject(logVoList);
			out.print(jsonArray);
		}else {
			out.print("");
		}
    }
    //根据logId 查找日志
    @RequestMapping("/findLogById")
    @ResponseBody
    public void findLogById(HttpServletResponse response,int logId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	LogVo logVo=logService.findLogById(logId);
    	if (logVo != null) {
			JSONObject jsonObject = JSONObject.fromObject(logVo);
			out.print(jsonObject);
		}else {
			out.print("");
		}
    }

    
    
}
