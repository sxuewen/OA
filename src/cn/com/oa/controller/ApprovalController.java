package cn.com.oa.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalType;
import cn.com.oa.pojo.ApprovalVo;
import cn.com.oa.pojo.ChuChaiApp;
import cn.com.oa.pojo.DaoXiuApp;
import cn.com.oa.pojo.DepartmentVo;
import cn.com.oa.pojo.JiaBanApp;
import cn.com.oa.pojo.LiZhiApp;
import cn.com.oa.pojo.QingJiaApp;
import cn.com.oa.pojo.RuZhiApp;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.TiaoGangApp;
import cn.com.oa.pojo.WaiChuApp;
import cn.com.oa.pojo.ZhuanZhengApp;
import cn.com.oa.service.ApprovalService;
import cn.com.oa.service.ApprovalTypeService;
import cn.com.oa.service.DepartmentService;
import cn.com.oa.util.JsonUtils;
import cn.com.oa.util.JudgeNotNull;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("approval")
@Controller
public class ApprovalController {

    private int count;
    private int rows;
    private int pageSize=5; 
    
    @Autowired
    private ApprovalService approvalService;
       
    @Autowired
    private ApprovalTypeService appTypeService;
    
    @Autowired
    private DepartmentService departmentService;
    
    // 查询我的申请列表
    @RequestMapping(value="/findSelfApplication")
    public String findSelfApplication(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            HttpServletRequest request,Model model){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");         
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountBysfId(staff.getSfId(),"");
        List<ApprovalVo> approvalVoList=approvalService.findApprovalVoBysfId(staff.getSfId(),"",rows,pageSize);      
        
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("approvalVoList", approvalVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/selfApplicationList";
        }else {
            System.out.println("暂无数据!");
            return "approval/selfApplicationList";
        }            
    }
    
    
    /**
     * 根据日期查询我的申请
     * @return
     */
    @RequestMapping(value="/selectMyAppByDate")
    public String selectMyAppByDate(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("createDate") String createDate,HttpServletRequest request,Model model){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");         
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountBysfId(staff.getSfId(),createDate);
        List<ApprovalVo> approvalVoList=approvalService.findApprovalVoBysfId(staff.getSfId(),createDate,rows,pageSize);      
        
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("createDate", createDate);
            model.addAttribute("approvalVoList", approvalVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/selfApplicationList";
        }else {
            System.out.println("暂无数据!");
            return "approval/selfApplicationList";
        }            
    }
    
    
    // 跳转到填写申请表页面
    @RequestMapping(value="/addApplication")
    public String addApplication(HttpServletRequest request,Model model){
        List<ApprovalType> appTypeList=appTypeService.findAppTypes();        
        model.addAttribute("appTypeList", appTypeList);
        return "approval/applicationAdd";
    }
    
   
    // 保存我的申请表
    @RequestMapping(value="/saveApplication")
    public String saveApplication(Approval approval,ChuChaiApp chuChaiApp,DaoXiuApp daoXiuApp,
            JiaBanApp jiaBanApp,LiZhiApp liZhiApp,QingJiaApp qingJiaApp,RuZhiApp ruZhiApp,
            TiaoGangApp tiaoGangApp,WaiChuApp waiChuApp,ZhuanZhengApp zhuanZhengApp,
            @RequestParam(value="count",required=false) Integer count,
            @RequestParam("roleLevel") Integer roleLevel,
            @RequestParam("departmentId") Integer departmentId,
            @RequestParam("departmentLevel") Integer departmentLevel) throws Exception{
                      
        List<Object> objectList=new ArrayList<Object>();
        objectList.add(chuChaiApp);
        objectList.add(daoXiuApp);
        objectList.add(jiaBanApp);
        objectList.add(liZhiApp);
        objectList.add(qingJiaApp);
        objectList.add(ruZhiApp);
        objectList.add(tiaoGangApp);
        objectList.add(waiChuApp);
        objectList.add(zhuanZhengApp);
        
        for (Object object : objectList) {
            if (JudgeNotNull.isFieldsNotNull(object)==true) {   // 属性都不为空
                approval.setAppContent(JsonUtils.objectToJson(object));              
            }
        }        
        DepartmentVo dpmVo=departmentService.finddpmVoById(departmentId);                               
        if (departmentLevel==1&&roleLevel!=1) {                         // 人力部普通员工            
            approval.setDpmId(departmentId);
            approval.setPreRoleLevel("1");
            approval.setPreDpmLevel("1");
            approval.setDayFlag(0);                                  
        }else if (departmentLevel!=1&&dpmVo==null&&roleLevel==1) {   // 父部门经理（直接交给人力部经理）            
            approval.setDpmId(departmentService.finddpmIdBydpmLevel(1));
            approval.setPreRoleLevel("1");
            approval.setPreDpmLevel("1");
            approval.setDayFlag(0);            
        }else if (departmentLevel!=1&&roleLevel!=1) {   // 普通员工
            if (approval.getHaveTime()==0) {     // 无时间（直接交给所在部门经理）
                approval.setDpmId(departmentId);
                approval.setPreRoleLevel("1");
                approval.setPreDpmLevel(String.valueOf(departmentLevel)); 
                approval.setDayFlag(0);
            } else if(approval.getHaveTime()==1){  // 加班（直接交给直属上级）                
                approval.setDpmId(departmentId);   // 按小时
                approval.setPreRoleLevel(String.valueOf(roleLevel-1));
                approval.setPreDpmLevel(String.valueOf(departmentLevel));
                approval.setDayFlag(0);               
            }else{                
                approval.setDpmId(departmentId);   // 按天数
                approval.setPreRoleLevel(String.valueOf(roleLevel-1));
                approval.setPreDpmLevel(String.valueOf(departmentLevel));
                if (count>=3) {
                    approval.setDayFlag(1);
                } else {
                    approval.setDayFlag(0);
                }
            }            
        }else if (departmentLevel!=1&&dpmVo!=null&&roleLevel==1) {   // 子部门经理（直接交给父部门经理）
            approval.setDpmId(Integer.valueOf(dpmVo.getParentId()));
            approval.setPreRoleLevel("1");
            approval.setPreDpmLevel(String.valueOf(departmentLevel));
            approval.setDayFlag(0);            
        }                 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        approval.setCreateDate(sdf.format(new Date()));
        approval.setState(0);  // 0:待审批状态                 
        approvalService.saveApplication(approval);
        return "redirect:findSelfApplication";
    }
    
   
    
    // 查询申请表的详细信息
    @RequestMapping(value="/findAppInfoByappId")
    public String findApprovalById(@RequestParam("appId") int appId,Model model){
                  
        ApprovalVo approvalVo=approvalService.findApprovalVoByappId(appId);         
        model.addAttribute("approvalVo", approvalVo);
        List<Class<?>> list=new ArrayList<Class<?>>();
        list.add(0, ChuChaiApp.class);
        list.add(1, DaoXiuApp.class);
        list.add(2, JiaBanApp.class);
        list.add(3, LiZhiApp.class);
        list.add(4, QingJiaApp.class);
        list.add(5, RuZhiApp.class);
        list.add(6, TiaoGangApp.class);
        list.add(7, WaiChuApp.class);
        list.add(8, ZhuanZhengApp.class);        
        for (int i = 1; i <= 9 ; i++) {            
            if (approvalVo.getAppTypeId()==i) {                
                model.addAttribute("appData"+i,JsonUtils.jsonToPojo(approvalVo.getAppContent(), list.get(i-1)));           
                break;
            }
        }        
        return "approval/applicationInfo";      
    }
    
    
    // 待我审批
    @RequestMapping(value="/findWaitApproval")
    public String findAllApproval(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            HttpServletRequest request,Model model){
        
        rows = (pageNow - 1) * pageSize;        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");                           
        if (staff.getDpmId().getDpmLevel()==1&&staff.getRoleId().getRoleLevel()==1) {   // 人力部经理审批
            count = approvalService.findCountByLevelAndResult("1","1");
            List<ApprovalVo> approvalVoList=approvalService.findAppByLevelAndResult("1","1",rows,pageSize);
            if (approvalVoList!=null&&approvalVoList.size()>0) {
                model.addAttribute("approvalVoList", approvalVoList);
                PageBean page=new PageBean(pageNow, count, pageSize);
                model.addAttribute("page", page);
                return "approval/approvalList";
            }else {
                System.out.println("暂无数据!");
                return "approval/approvalList";
            }             
        }else if (staff.getDpmId().getDpmLevel()!=1&&staff.getRoleId().getRoleLevel()==1){   // 部门经理审批
            count = approvalService.findCountBydpmIdAndroleLevel(staff.getDpmId().getDpmId(),"1");
            List<ApprovalVo> approvalVoList=approvalService.findAppBydpmIdAndroleLevel(staff.getDpmId().getDpmId(),"1",rows,pageSize);
            if (approvalVoList!=null&&approvalVoList.size()>0) {
                model.addAttribute("approvalVoList", approvalVoList);
                PageBean page=new PageBean(pageNow, count, pageSize);
                model.addAttribute("page", page);
                return "approval/approvalList";
            }else {
                System.out.println("暂无数据!");
                return "approval/approvalList";
            }                        
        }else if (staff.getDpmId().getDpmLevel()!=1&&staff.getRoleId().getRoleLevel()!=1) {  // 普通上级审批
            count = approvalService.findCountBydpmIdAndroleLevel(staff.getDpmId().getDpmId(), String.valueOf(staff.getRoleId().getRoleLevel()));
            List<ApprovalVo> approvalVoList=approvalService.findAppBydpmIdAndroleLevel(staff.getDpmId().getDpmId(),String.valueOf(staff.getRoleId().getRoleLevel()),rows,pageSize);
            if (approvalVoList!=null&&approvalVoList.size()>0) {
                model.addAttribute("approvalVoList", approvalVoList);
                PageBean page=new PageBean(pageNow, count, pageSize);
                model.addAttribute("page", page);
                return "approval/approvalList";
            }else {
                System.out.println("暂无数据!");
                return "approval/approvalList";
            }                        
        }
        return null;        
    }
    
    
    // 跳转到各种审批页面
    @RequestMapping(value="/startApproval")
    public String startApproval(@RequestParam("appId") Integer appId,Model model,
            @RequestParam("appTypeId") Integer appTypeId,HttpServletRequest request){
                
        ApprovalVo approvalVo=approvalService.findApprovalVoByappId(appId);
        model.addAttribute("approvalVo", approvalVo);        
        if (appTypeId==1) {
            ChuChaiApp chuChaiApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(),ChuChaiApp.class);
            model.addAttribute("chuChaiApp", chuChaiApp);
            return "approval/ChuChaiApproval";
        }else if (appTypeId==2){
            DaoXiuApp daoXiuApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), DaoXiuApp.class);
            model.addAttribute("daoXiuApp", daoXiuApp);
            return "approval/DaoXiuApproval";
        }else if (appTypeId==3) {
            JiaBanApp jiaBanApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), JiaBanApp.class);
            model.addAttribute("jiaBanApp", jiaBanApp);
            return "approval/JiaBanApproval";
        }else if (appTypeId==4) {
            LiZhiApp liZhiApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), LiZhiApp.class); 
            model.addAttribute("liZhiApp", liZhiApp);
            return "approval/LiZhiApproval";
        }else if (appTypeId==5) {
            QingJiaApp qingJiaApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), QingJiaApp.class);
            model.addAttribute("qingJiaApp", qingJiaApp);
            return "approval/QingJiaApproval";
        }else if (appTypeId==6) {
            RuZhiApp ruZhiApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), RuZhiApp.class);
            model.addAttribute("ruZhiApp", ruZhiApp);
            return "approval/RuZhiApproval";
        }else if (appTypeId==7) {
            TiaoGangApp tiaoGangApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), TiaoGangApp.class);
            model.addAttribute("tiaoGangApp", tiaoGangApp);
            return "approval/TiaoGangApproval";
        }else if (appTypeId==8) {
            WaiChuApp waiChuApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), WaiChuApp.class);
            model.addAttribute("waiChuApp", waiChuApp);
            return "approval/WaiChuApproval";
        }else if (appTypeId==9){
            ZhuanZhengApp zhuanZhengApp=JsonUtils.jsonToPojo(approvalVo.getAppContent(), ZhuanZhengApp.class);
            model.addAttribute("zhuanZhengApp", zhuanZhengApp);
            return "approval/ZhuanZhengApproval";
        }
        return null;               
    }
    
    
    // 进行审批
    @RequestMapping(value="/updateApproval")
    public String updateApproval(@RequestParam("appId") Integer appId,HttpServletRequest request,
            @RequestParam("flag") String flag,@RequestParam("rfReason") String rfReason){
        
        
        Approval approval=approvalService.findAppByappId(appId); 
        if (rfReason!=null) {
            approval.setRefuseReason(rfReason);    
        }
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        int departmentId=staff.getDpmId().getDpmId();
        int departmentLevel=staff.getDpmId().getDpmLevel();
        int roleLevel=staff.getRoleId().getRoleLevel(); 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
        String tip="";        
        if ("0".equals(flag)) {   // 不同意            
            tip="不同意";
        } else {
            tip="同意";
        }                               
        if (departmentLevel==1&&roleLevel==1) {      // 人力部经理          
            approval.setDpmId(departmentId);
            approval.setDayFlag(0);            
            approval.setPreRoleLevel(null);
            approval.setPreDpmLevel(null); 
            approval.setState(2);
            approval.setProcess(staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
            approval.setApprover(""+staff.getSfId()); 
            approval.setResult(flag);
            approval.setResultDate(sdf.format(new Date()));                                  
        }else if (departmentLevel!=1&&roleLevel==1) {   // 部门经理            
            approval.setDpmId(departmentId);
            approval.setDayFlag(0); 
            approval.setPreRoleLevel(null);
            approval.setPreDpmLevel(null);
            approval.setState(2);
            if (approval.getProcess()==null) {
                approval.setProcess(staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
            } else {
                approval.setProcess(approval.getProcess()+" ——> "+staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
            } 
            if (approval.getApprover()==null) {
                approval.setApprover(""+staff.getSfId());
            } else {
                approval.setApprover(approval.getApprover()+","+staff.getSfId());
            }
            approval.setResult(flag);
            approval.setResultDate(sdf.format(new Date()));            
        }else if (departmentLevel!=1&&roleLevel!=1) {   // 部门普通员工
            if (approval.getDayFlag()==0) {  //  交给本部门直属上级，直接可以得出结果
                approval.setDpmId(departmentId);
                approval.setPreRoleLevel(null);
                approval.setPreDpmLevel(null);
                approval.setState(2);   //  已审批
                approval.setProcess(staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
                approval.setApprover(""+staff.getSfId());
                approval.setResult(flag);
                approval.setResultDate(sdf.format(new Date()));
            }else{
                approval.setDpmId(departmentId);
                approval.setPreRoleLevel(String.valueOf(roleLevel-1));  
                approval.setPreDpmLevel(String.valueOf(departmentLevel));
                approval.setState(1);   //  审批中
                if (approval.getProcess()==null) {
                    approval.setProcess(staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
                } else {
                    approval.setProcess(approval.getProcess()+" ——> "+staff.getSfUserName()+"-"+staff.getSfRealName()+":"+tip);
                } 
                if (approval.getApprover()==null) {
                    approval.setApprover(""+staff.getSfId());
                } else {
                    approval.setApprover(approval.getApprover()+","+staff.getSfId());
                }                
            }                                                
        }                                     
        approvalService.updateApplication(approval);        
        return "redirect:findWaitApproval";
    }
    
    
    /**
     * 查看审批进程   
     */
    @RequestMapping(value="/findProcess")
    public String findProcess(@RequestParam("appId") Integer appId,Model model){
        Approval approval=approvalService.findAppByappId(appId);
        model.addAttribute("approval", approval);
        return "approval/findProcess";
    }
    
    
    /**
     * 查看自己已经审批的
     * @return
     */
    @RequestMapping(value="/findHaveApproval")
    public String findHaveApproval(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            HttpServletRequest request,Model model){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountWithApprover(staff.getSfId(),"");
        List<ApprovalVo> approvalVoList=approvalService.findAppByApprover(staff.getSfId(),"",rows,pageSize);
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("approvalVoList", approvalVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/haveApprovalList";
        }else {
            System.out.println("暂无数据!");
            return "approval/haveApprovalList";
        }         
    }
    
    
    /**
     * 根据申请人姓名查看自己已经审批的
     * @param pageNow
     * @param sfRealName
     * @param model
     * @return
     */
    @RequestMapping(value="/selectHAppByRealName")
    public String selectHAppByRealName(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("sfRealName") String sfRealName,Model model,HttpServletRequest request){
        
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountWithApprover(staff.getSfId(),sfRealName);
        List<ApprovalVo> approvalVoList=approvalService.findAppByApprover(staff.getSfId(),sfRealName,rows,pageSize);
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("sfRealName", sfRealName);
            model.addAttribute("approvalVoList", approvalVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/haveApprovalList";
        }else {
            System.out.println("暂无数据!");
            return "approval/haveApprovalList";
        }   
        
    }
    
   
    /**
     * 分页查询所有带结果的申请（人力部专属功能）
     * @return
     */
    @RequestMapping(value="/findAllApplication")
    public String findAllApplication(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            Model model){
        
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountWithResult("");
        List<ApprovalVo> approvalVoList=approvalService.findAppWithResult("",rows,pageSize);
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("approvalVoList", approvalVoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/approvalManage";
        }else {
            System.out.println("暂无数据!");
            return "approval/approvalManage";
        }                 
    }
    
    /**
     * 根据申请人姓名分页查询所有带结果的申请（人力部专属功能）
     * @param pageNow
     * @param sfRealName
     * @param model
     * @return
     */
    @RequestMapping(value="/selectAppByRealName")
    public String selectAppByRealName(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("sfRealName") String sfRealName,Model model){
        
        rows = (pageNow - 1) * pageSize;
        count=approvalService.findCountWithResult(sfRealName);
        List<ApprovalVo> approvalVoList=approvalService.findAppWithResult(sfRealName,rows,pageSize);
        if (approvalVoList!=null&&approvalVoList.size()>0) {
            model.addAttribute("approvalVoList", approvalVoList);
            model.addAttribute("sfRealName", sfRealName);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "approval/approvalManage";
        }else {
            System.out.println("暂无数据!");
            return "approval/approvalManage";
        } 
    }
    
    
    /**
     * 根据ids批量删除
     * @return
     */
    @RequestMapping(value="/deleteApproval")
    public String deleteApproval(@RequestParam("ids") String[] sids){
        Integer[] ids = StrToInt.converterStringArray2IntegerArray(sids);
        approvalService.deleteApproval(ids);
        return "redirect:findAllApplication";
    }
    
    /**
     * 查看未通过原因
     * @param appId
     * @param model
     * @return
     */
    @RequestMapping(value="/findrfReason")
    public String findrfReason(@RequestParam("appId") Integer appId,Model model){
        Approval approval=approvalService.findAppByappId(appId);
        model.addAttribute("approval", approval);
        return "approval/findrfReason";
    }
        
}
