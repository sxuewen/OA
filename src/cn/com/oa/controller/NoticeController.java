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
import cn.com.oa.pojo.Notice;
import cn.com.oa.pojo.NoticeVo;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffNotice;
import cn.com.oa.service.NoticeService;
import cn.com.oa.service.StaffNoticeService;
import cn.com.oa.service.StaffService;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("notice")
@Controller
public class NoticeController {
    
    private int count;
    private int rows;
    private int pageSize=5; 
    
    @Autowired
    private NoticeService noticeService;
    
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private StaffNoticeService staffNoticeService;
    
    /**
     * 分页查询所有公告
     * @param pageNow
     * @param model
     * @return
     */
    @RequestMapping("/findAllNotice")
    public String findAllNotice(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model){
        rows = (pageNow - 1) * pageSize;
        count=noticeService.findCount();
        List<NoticeVo> noticeList=noticeService.findAllNotice(rows,pageSize);      
        
        if (noticeList!=null&&noticeList.size()>0) {
            int number=staffService.findCount();
            for (NoticeVo noticeVo : noticeList) {
                noticeVo.setNoNum(number-noticeVo.getYesNum());
            }
            
            model.addAttribute("noticeList", noticeList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "notice/noticeList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 根据日期，分页查询公告
     * @param pageNow
     * @param notDate
     * @param model
     * @return
     */
    @RequestMapping("/selectNotice")
    public String selectNotice(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("notDate") String notDate,Model model){
        rows = (pageNow - 1) * pageSize;
        count=noticeService.findCountByCondition(notDate);
        List<NoticeVo> noticeList=noticeService.findNoticeByCondition(notDate,rows,pageSize);
        
        if (noticeList!=null&&noticeList.size()>0) {
            int number=staffService.findCount();
            for (NoticeVo noticeVo : noticeList) {
                noticeVo.setNoNum(number-noticeVo.getYesNum());
            }
            model.addAttribute("notDate", notDate);
            model.addAttribute("noticeList", noticeList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "notice/noticeList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 跳转到公告修改页面
     * @param notId
     * @param model
     * @return
     */
    @RequestMapping("/findNoticeInfo")
    public String findNoticeInfo(@RequestParam("notId") Integer notId,Model model){
        
        NoticeVo noticeVo=noticeService.findNoticeVoById(notId);
        if (noticeVo!=null) {
            model.addAttribute("noticeVo", noticeVo);
            return "notice/noticeUpdate";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }        
    }
    
    /**
     * 更新公告
     * @return
     */
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice){       
        noticeService.updateNotice(notice);
        return "redirect:findAllNotice";
    }
    
    /**
     * 根据id批量删除
     * @return
     */
    @RequestMapping("/deleteNotice")
    public String deleteNotice(@RequestParam("ids") String[] sids){
        Integer[] ids=StrToInt.converterStringArray2IntegerArray(sids);
        noticeService.deleteByIds(ids);
        return "redirect:findAllNotice";
    }
    
    /**
     * 跳转到添加公告页面
     * @return
     */
    @RequestMapping("/addNotice")
    public String addNotice(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        model.addAttribute("sfId", staff.getSfId());
        model.addAttribute("adminName", staff.getSfUserName());
        return "notice/noticeAdd";
    }
    
    /**
     * 保存添加的公告
     * @return
     */
    @RequestMapping("/saveNotice")
    public String saveNotice(Notice notice,@RequestParam("sfId") Integer sfId){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        notice.setNotDate(sdf.format(new Date()));
        noticeService.saveNotice(notice);
        int notId=noticeService.findCount();
        
        // 将创建者插入到staff_notice表中
        StaffNotice staffNotice=new StaffNotice();
        staffNotice.setNotId(notId);
        staffNotice.setSfId(sfId);
        staffNotice.setState(1);
        staffNoticeService.addStaffNotice(staffNotice);
        
        return "redirect:findAllNotice";
    }
    
    
    /**
     * 显示所有公告（一般部门）
     * @return
     */
    @RequestMapping("/seeAllNotice")
    public String seeAllNotice(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model,
            HttpServletRequest request){
        rows = (pageNow - 1) * pageSize;
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        count=noticeService.findCount();
        List<NoticeVo> noticeVoList=noticeService.findAllNotice(rows,pageSize);
                
        if (noticeVoList!=null&&noticeVoList.size()>0) { 
            for (int i = 0; i < noticeVoList.size(); i++) {
                StaffNotice staffNotice=staffNoticeService.findNoticeBysfAndnot(staff.getSfId(),noticeVoList.get(i).getNotId());
                if (staffNotice!=null) {
                    noticeVoList.get(i).setFlag(1);
                }
            }
            model.addAttribute("noticeVoList", noticeVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "notice/seeNoticeList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 按日期查看公告（一般部门）
     * @return
     */
    @RequestMapping("/seeNoticeByDate")
    public String seeNoticeByDate(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("notDate") String notDate,Model model,HttpServletRequest request){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        
        rows = (pageNow - 1) * pageSize;
        count=noticeService.findCountByCondition(notDate);
        List<NoticeVo> noticeVoList=noticeService.findNoticeByCondition(notDate,rows,pageSize);
                
        if (noticeVoList!=null&&noticeVoList.size()>0) {
            for (int i = 0; i < noticeVoList.size(); i++) {
                StaffNotice staffNotice=staffNoticeService.findNoticeBysfAndnot(staff.getSfId(),noticeVoList.get(i).getNotId());
                if (staffNotice!=null) {
                    noticeVoList.get(i).setFlag(1);
                }
            }            
            model.addAttribute("notDate", notDate);
            model.addAttribute("noticeVoList", noticeVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "notice/seeNoticeList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 查看公告详细信息（一般部门）
     * @return
     */
    @RequestMapping("/seeNoticeInfo")
    public String seeNoticeInfo(@RequestParam("notId") Integer notId,
            @RequestParam("sfId") Integer sfId,Model model){
        
        NoticeVo noticeVo=noticeService.findNoticeVoById(notId);
        if (noticeVo!=null) {
            StaffNotice staffNotice=staffNoticeService.findNoticeBysfAndnot(sfId, notId);
            if (staffNotice!=null) {
                noticeVo.setFlag(1);    // 已读
            }
            model.addAttribute("noticeVo", noticeVo);
            return "notice/seeNoticeInfo";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }  
    }
    
    @RequestMapping(value="/setHaveRead")
    public void setHaveRead(@RequestParam("notId") Integer notId,@RequestParam("sfId") Integer sfId){
     
        StaffNotice staffNotice=new StaffNotice();
        staffNotice.setNotId(notId);
        staffNotice.setSfId(sfId);
        staffNotice.setState(1);
        staffNoticeService.addStaffNotice(staffNotice);
    }
    
}
