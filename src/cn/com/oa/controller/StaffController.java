package cn.com.oa.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.Role;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffInfo;
import cn.com.oa.service.DepartmentService;
import cn.com.oa.service.RoleService;
import cn.com.oa.service.StaffService;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("staff")
@Controller
public class StaffController {

    private int count;
    private int rows;
    private int pageSize=5; 
    
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService dpmService;
    @Autowired
    private RoleService roleService;
    
    // 验证登录信息
    @RequestMapping(value="/userLogin")
    public String userLogin(@RequestParam("userName") String userName,
            @RequestParam("password") String password,
            Model model,HttpServletRequest request){
        Staff staff=staffService.login(userName,password);
        if (staff==null) {
            System.out.println("登录失败!");
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }else {
            System.out.println("登录成功!");
            HttpSession session=request.getSession();
            session.setAttribute("staff", staff);
            session.setAttribute("sfUserName", staff.getSfUserName());         
            return "menu/main";
        }
    }
    
    // 查询主要信息
    @RequestMapping(value="/findAllStaff")
    public String findAllStaff(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model) {
        rows = (pageNow - 1) * pageSize;
        count=staffService.findCount();
        List<StaffInfo> staffList=staffService.findAllStaffInfo(rows,pageSize);
        if (staffList!=null&&staffList.size()>0) {
            model.addAttribute("staffList", staffList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "staff/staffList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    // 查询详细信息
    @RequestMapping(value="/findStaffById")
    public String findStaffById(@RequestParam("sfId") int sfId,Model model){
        StaffInfo staffInfo=staffService.findStaffById(sfId);
        if (staffInfo!=null) {
            model.addAttribute("staffInfo", staffInfo);
            return "staff/staffInfo";
        }else {
            System.out.println();
            return "common/error";
        }  
    }
    
    // 多条件查询
    @RequestMapping(value="/selectStaff")
    public String selectStaff(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("sfUserName") String UserName,@RequestParam("dpmName") String dpmName,
            @RequestParam("roleName") String roleName,Model model){
        
        rows = (pageNow - 1) * pageSize;
        count=staffService.findCountByCondition(UserName,dpmName,roleName);
        List<StaffInfo> staffList=staffService.findAllStaff(UserName,dpmName,roleName,rows,pageSize);
        if (staffList!=null&&staffList.size()>0) {
            model.addAttribute("UserName", UserName);
            model.addAttribute("dpmName", dpmName);
            model.addAttribute("roleName", roleName);
            model.addAttribute("staffList", staffList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "staff/staffList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }    
    }
    
    // 检查用户名是否可用
    @RequestMapping(value="/checksfUserName")
    public void checksfUserName(@RequestParam("sfUserName") String sfUserName,
            HttpServletRequest request,HttpServletResponse response) throws Exception{
        
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        Staff staff=staffService.checksfUserName(sfUserName);
        if (staff==null) {
            out.print("可以使用");
        } else {
            out.print("已存在");
        }
    }
    
    // 跳转到员工添加页面
    @RequestMapping(value="/addStaff")
    public String addStaff(Model model){
        List<Department> dpmList=dpmService.findAllDepartments();
        model.addAttribute("dpmList", dpmList);
        return "staff/staffAdd";
    }
    
    // 保存员工信息
    @RequestMapping(value="/saveStaff")
    public String saveStaff(Staff staff,@RequestParam("dpm") Integer dpmId ,
            @RequestParam("role") Integer roleId,Model model){
        staff.setSfPassword("123456");
        Department department=dpmService.finddpmById(dpmId);
        Role role=roleService.findRoleInfoById(roleId);
        staff.setDpmId(department);
        staff.setRoleId(role);
        staffService.saveStaff(staff);
        return "redirect:findAllStaff";
    }
    
    // 跳转到员工信息修改页面
    @RequestMapping(value="/findStaffInfo")
    public String findStaffInfo(@RequestParam("sfId") Integer sfId,Model model){
        StaffInfo staffInfo=staffService.findStaffById(sfId);
        List<Department> dpmList=dpmService.findAllDepartments();
        Staff staff=staffService.findStaffBysfId(sfId);
        List<Role> roleList=roleService.selectRoleBydpmId(staff.getDpmId().getDpmId());
        model.addAttribute("staffInfo", staffInfo);
        model.addAttribute("dpmList", dpmList);
        model.addAttribute("roleList", roleList);
        return "staff/staffUpdate";     
    }
    
    // 修改员工信息
    @RequestMapping(value="/updateStaff")
    public String updateStaff(Staff staff,@RequestParam("dpm") Integer dpmId ,
            @RequestParam("role") Integer roleId){
        Department department=dpmService.finddpmById(dpmId);
        Role role=roleService.findRoleInfoById(roleId);
        staff.setDpmId(department);
        staff.setRoleId(role);
        staffService.updateStaff(staff);
        return "redirect:findAllStaff";       
    }
    
    // 删除员工信息
    @RequestMapping(value="/deleteStaff")
    public String deleteStaff(@RequestParam("ids") String[] sids,
            HttpServletRequest request,HttpServletResponse response){
        
        Integer[] ids=StrToInt.converterStringArray2IntegerArray(sids);
        staffService.deleteStaffByIds(ids);
        return "redirect:findAllStaff";   
    }
    
    // 查询个人信息
    @RequestMapping(value="/findPersonalInfo")
    public String findPersonalInfo(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        StaffInfo sfInfo=staffService.findStaffById(staff.getSfId());
        model.addAttribute("sfInfo", sfInfo);
        return "system/personalInfo";
    }
    
    // 跳转到个人信息修改页面
    @RequestMapping(value="/updatePersonalInfo")
    public String updatePersonalInfo(@RequestParam("sfId") Integer sfId,Model mode){
        StaffInfo staffInfo=staffService.findStaffById(sfId);
        mode.addAttribute("staffInfo", staffInfo);
        return "system/personalInfoUpdate";
    }
    
    // 保存修改后的个人信息
    @RequestMapping(value="/savePersonalInfo")
    public String savePersonalInfo(Staff staff){
        staffService.savePersonalInfo(staff);
        return "redirect:findPersonalInfo";
    }
    
    // 跳转到个人密码修改页面
    @RequestMapping(value="/alterPassword")
    public String alterPassword(){
        return "system/alterPassword";
    }
    
    // 检查旧密码是否正确
    @RequestMapping(value="/checkPassword")
    public void checkPassword(@RequestParam("oldpsd") String oldpsd,
            HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        if (oldpsd.equals(staff.getSfPassword())) {
            out.print("密码正确");
        } else {
            out.print("密码不正确");
        }
    }
    
    // 修改个人密码
    @RequestMapping(value="/updatePassword")
    public String updatePassword(@RequestParam("newpsd") String newpsd,
            HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        Staff staff=(Staff) session.getAttribute("staff");
        staffService.updatePassword(newpsd,staff.getSfId());
        model.addAttribute("alterSuccess", "修改成功!");
        return "common/relogin";
    }
    
    // 注销，退出系统
    @RequestMapping(value="/exitSystem")
    public String exitSystem(HttpServletRequest request,Model model){
        HttpSession session=request.getSession();
        session.removeAttribute("staff");
        model.addAttribute("exitSuccess", "注销成功!");
        return "common/relogin";
    }
    
}
