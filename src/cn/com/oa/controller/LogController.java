package cn.com.oa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.oa.pojo.DayLog;
import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;
import cn.com.oa.pojo.MeetingLog;
import cn.com.oa.pojo.Staff;
import cn.com.oa.service.LogService;
import cn.com.oa.util.JsonUtils;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("log")
@Controller
public class LogController {

    private int count;
    private int rows;
    private int pageSize=5; 
    
    @Autowired
    private LogService logService;
    
    /**
     * 查询所有日志（人力部）
     * @return
     */
    @RequestMapping("/findAllLog")
    public String findAllLog(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model){
        rows = (pageNow - 1) * pageSize;
        count=logService.findCount();
        List<LogVo> logVoList=logService.findAllLog(rows,pageSize);
        
        if (logVoList!=null&&logVoList.size()>0) {           
            model.addAttribute("logVoList", logVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "log/logList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 可以查看所有日志的详细内容（人力部）
     * @return
     */
    @RequestMapping("/findLogInfo")
    public String findLogInfo(@RequestParam("logId") Integer logId,Model model){
        
        LogVo logVo=logService.findLogById(logId);
        model.addAttribute("logVo", logVo);
        if (logVo.getLogType()==4) {
            MeetingLog meetingLog=JsonUtils.jsonToPojo(logVo.getLogContent(), MeetingLog.class);           
            model.addAttribute("meetingLog", meetingLog);
            return "log/meetingLogInfo";
        }else{
            DayLog dayLog=JsonUtils.jsonToPojo(logVo.getLogContent(), DayLog.class);
            model.addAttribute("dayLog", dayLog);
            return "log/dayLogInfo";
        }
    }
    
    /**
     * 跳转到添加日志页面（人力部）
     * @return
     */
    @RequestMapping("/addLog")
    public String addLog(Model model){        
        return "log/logAdd";
    }
    
    /**
     * 跳转到添加日志页面（一般部门）
     * @return
     */
    @RequestMapping("/adddpmLog")
    public String adddpmLog(){
        return "log/dpmLogAdd";
    }
    
    /**
     * 保存日、周、月报（人力部）
     * @return
     */
    @RequestMapping("/saveDayLog")
    public String saveDayLog(Log log,DayLog dayLog){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.setLogDate(sdf.format(new Date())); 
        
        System.out.println(JsonUtils.objectToJson(dayLog));
        log.setLogContent(JsonUtils.objectToJson(dayLog));
        
        logService.saveLog(log);
        return "redirect:findAllLog";
    }
    
    /**
     * 保存日、周、月报（一般部门）
     * @return
     */
    @RequestMapping("/savedpmDayLog")
    public String savedpmDayLog(Log log,DayLog dayLog){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.setLogDate(sdf.format(new Date())); 
        
        System.out.println(JsonUtils.objectToJson(dayLog));
        log.setLogContent(JsonUtils.objectToJson(dayLog));
        
        logService.saveLog(log);
        return "redirect:findLogBydpm";
    }
    
    /**
     * 保存会议纪要（人力部）
     * @return
     */
    @RequestMapping("/saveMeetingLog")
    public String saveMeetingLog(Log log,MeetingLog meetingLog){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.setLogDate(sdf.format(new Date()));            
        log.setLogContent(JsonUtils.objectToJson(meetingLog));       
        logService.saveLog(log);
        return "redirect:findAllLog";
    }
    
    /**
     * 保存会议纪要（一般部门）
     * @return
     */
    @RequestMapping("/savedpmMeetingLog")
    public String savedpmMeetingLog(Log log,MeetingLog meetingLog){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.setLogDate(sdf.format(new Date()));           
        log.setLogContent(JsonUtils.objectToJson(meetingLog));       
        logService.saveLog(log);
        return "redirect:findLogBydpm";
    }
    
    /**
     * 跳转到修改个人日志页面（人力部）
     * @param logId
     * @param model
     * @return
     */
    @RequestMapping("/editLog")
    public String editLog(@RequestParam("logId") Integer logId,Model model){
        LogVo logVo=logService.findLogById(logId);
        model.addAttribute("logVo", logVo);
        if (logVo.getLogType()==4) {
            MeetingLog meetingLog=JsonUtils.jsonToPojo(logVo.getLogContent(), MeetingLog.class);           
            model.addAttribute("meetingLog", meetingLog);
            return "log/meetingLogUpdate";
        }else{
            DayLog dayLog=JsonUtils.jsonToPojo(logVo.getLogContent(), DayLog.class);
            model.addAttribute("dayLog", dayLog);
            return "log/dayLogUpdate";
        }       
    }
    
    /**
     * 跳转到修改个人日志页面（一般部门）
     * @param logId
     * @param model
     * @return
     */
    @RequestMapping("/dpmEditLog")
    public String dpmEditLog(@RequestParam("logId") Integer logId,Model model){
        LogVo logVo=logService.findLogById(logId);
        model.addAttribute("logVo", logVo);
        if (logVo.getLogType()==4) {
            MeetingLog meetingLog=JsonUtils.jsonToPojo(logVo.getLogContent(), MeetingLog.class);           
            model.addAttribute("meetingLog", meetingLog);
            return "log/dpmMeetingLogUpdate";
        }else{
            DayLog dayLog=JsonUtils.jsonToPojo(logVo.getLogContent(), DayLog.class);
            model.addAttribute("dayLog", dayLog);
            return "log/dpmDayLogUpdate";
        }       
    }
    
    /**
     * 更新日、周、月报（人力部）
     * @return
     */
    @RequestMapping("/updateDayLog")
    public String updateDayLog(DayLog dayLog,Log log){
        log.setLogContent(JsonUtils.objectToJson(dayLog));
        logService.updateLog(log);
        return "redirect:findAllLog";
    }
    
    /**
     * 更新日、周、月报（一般部门）
     * @return
     */
    @RequestMapping("/dpmUpdateDayLog")
    public String dpmUpdateDayLog(DayLog dayLog,Log log){
        log.setLogContent(JsonUtils.objectToJson(dayLog));
        logService.updateLog(log);
        return "redirect:findLogBydpm";
    }
    
    /**
     * 更新会议纪要（人力部）
     * @return
     */
    @RequestMapping("/updateMeetingLog")
    public String updateMeetingLog(MeetingLog meetingLog,Log log){       
        log.setLogContent(JsonUtils.objectToJson(meetingLog));
        logService.updateLog(log);
        return "redirect:findAllLog";
    }
    
    /**
     * 更新会议纪要（一般部门）
     * @return
     */
    @RequestMapping("/dpmUpdateMeetingLog")
    public String dpmUpdateMeetingLog(MeetingLog meetingLog,Log log){       
        log.setLogContent(JsonUtils.objectToJson(meetingLog));
        logService.updateLog(log);
        return "redirect:findLogBydpm";
    }
    
    /**
     * 根据日期查询日志
     * @return
     */
    @RequestMapping("/selectLog")
    public String selectLog(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("logDate") String logDate,Model model){
        rows = (pageNow - 1) * pageSize;
        count=logService.findCountByCondition(logDate);
        List<LogVo> logVoList=logService.findLogByCondition(logDate,rows,pageSize);
        if (logVoList!=null&&logVoList.size()>0) {   
            model.addAttribute("logDate", logDate);
            model.addAttribute("logVoList", logVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "log/logList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 根据ids批量删除日志
     * @param sids
     * @return
     */
    @RequestMapping("/deleteLog")
    public String deleteLog(@RequestParam("ids") String[] sids) {
        Integer[] ids = StrToInt.converterStringArray2IntegerArray(sids);
        logService.deleteByIds(ids);
        return "redirect:findAllLog";
    }
    
    
    /**
     * 查询当前所在部门的所有日志
     * @return
     */
    @RequestMapping("/findLogBydpm")
    public String findLogBydpm(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        int dpmId=staff.getDpmId().getDpmId();
        count=logService.findCountBydpmId(dpmId,"");
        List<LogVo> logVoList=logService.findLogBydpmId(dpmId,"",rows,pageSize);
        if (logVoList!=null&&logVoList.size()>0) {           
            model.addAttribute("logVoList", logVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "log/dpmLogList";
        }else {
            System.out.println("暂无数据!");
            return "log/dpmLogList";
        }
    }
    
    /**
     * 根据日期查询所属部门的日志
     * @param pageNow
     * @param logDate
     * @param model
     * @return
     */
    @RequestMapping("/selectdpmLog")
    public String selectdpmLog(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("dpmId") Integer dpmId,@RequestParam("logDate") String logDate,Model model){
        rows = (pageNow - 1) * pageSize;
        count=logService.findCountBydpmId(dpmId,logDate);
        List<LogVo> logVoList=logService.findLogBydpmId(dpmId,logDate,rows,pageSize);
        if (logVoList!=null&&logVoList.size()>0) {   
            model.addAttribute("logDate", logDate);
            model.addAttribute("logVoList", logVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "log/dpmLogList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
}
