package cn.com.oa.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.oa.pojo.Sign;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffSign;
import cn.com.oa.pojo.StaffSignVo;
import cn.com.oa.service.SignService;
import cn.com.oa.service.StaffSignService;

@RequestMapping("sign")
@Controller
public class SignController {

    @Autowired
    private SignService signService;
    
    @Autowired
    private StaffSignService staffSignService;
    
    
    /**
     * 考勤设置（人力部）
     * @return
     */
    @RequestMapping(value="/settingSign")
    public String settingSign(Model model){  
        Sign sign=signService.findSign();
        model.addAttribute("sign", sign);
        return "sign/signList";
    }
    
    
    /**
     * 修改页面
     * @return
     */
    @RequestMapping(value="/updateSign")
    public String updateSign(Model model){
        Sign sign=signService.findSign();
        model.addAttribute("sign", sign);
        return "sign/signUpdate";
    }
    
    
    /**
     * 保存修改数据
     * @return
     */
    @RequestMapping(value="/saveSign")
    public String saveSign(Sign sign){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        sign.setSignDate(sdf.format(new Date()));
        signService.updateSign(sign);
        return "redirect:settingSign";
    }
    
    
    /**
     * 封装 StaffSignVo对象
     * @param staffSignList
     * @return
     */
    public static StaffSignVo setSignVo(List<StaffSign> staffSignList,String date){
        
        StaffSignVo signVo=new StaffSignVo();
        signVo.setDuring(date);
        
        for (StaffSign staffSign : staffSignList) {
            
            if ("1".equals(staffSign.getIsWork())) {
                signVo.setWorkCount(signVo.getWorkCount()+1);              
            }
            if ("1".equals(staffSign.getIsRest())) {
                signVo.setRestCount(signVo.getRestCount()+1);
            }
            if ("1".equals(staffSign.getIsLate())) {
                signVo.setLateCount(signVo.getLateCount()+1);     
            }
            if ("1".equals(staffSign.getIsTooLate())) {
                signVo.setLateCount(signVo.getLateCount()+1); 
            }
            if ("1".equals(staffSign.getIsBack())) {
                signVo.setBackCount(signVo.getBackCount()+1);
            }
            if ("1".equals(staffSign.getIsLose())) {
                signVo.setLoseCount(signVo.getLoseCount()+1);
            }
            if ("1".equals(staffSign.getIsAbsence())) {
                signVo.setAbsenceCount(signVo.getAbsenceCount()+1);
            }
            if ("1".equals(staffSign.getIsOutside())) {
                signVo.setOutsideCount(signVo.getOutsideCount()+1);
            }
            if ("1".equals(staffSign.getIsAddWork())) {
                signVo.setAddWorkCount(signVo.getAddWorkCount()+1);
            }
        } 
        return signVo;
    }
    
    /**
     * 统计个人出勤情况
     * @return
     */
    @RequestMapping(value="/staffSignInfo")
    public String staffSignInfo(HttpServletRequest request,Model model){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");   //  2019-09
        String currentDate=sdf.format(new Date());
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd"); 
        
        // 统计本月出勤情况
        List<StaffSign> staffSignList=staffSignService.findSignWithCurrent(staff.getSfId(),currentDate);                                
        model.addAttribute("signVo", setSignVo(staffSignList, currentDate));
        
        // 统计前六个月的出勤情况
        Calendar calendar=Calendar.getInstance();    // 获取前六个月第一天
        calendar.add(Calendar.MONTH, -6);
        calendar.set(Calendar.DAY_OF_MONTH, 1);           
        String firstDay=sdf2.format(calendar.getTime());    
        
        Calendar calendar2=Calendar.getInstance();   // 获取上个月最后一天
        calendar2.set(Calendar.DAY_OF_MONTH, 0);        
        String lastDay=sdf2.format(calendar2.getTime());      
        
        String currentDate2=firstDay.substring(0,7)+"~"+lastDay.substring(0,7);

        List<StaffSign> staffSignList2=staffSignService.findSignWithSixMonth(staff.getSfId(),firstDay,lastDay);
        model.addAttribute("signVo2", setSignVo(staffSignList2, currentDate2));
        
        return "sign/staffSign";
    }
    
    
}
