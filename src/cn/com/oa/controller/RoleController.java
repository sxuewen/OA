package cn.com.oa.controller;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.Role;
import cn.com.oa.pojo.RoleInfo;
import cn.com.oa.pojo.Staff;
import cn.com.oa.service.DepartmentService;
import cn.com.oa.service.RoleService;
import cn.com.oa.service.StaffService;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("role")
@Controller
public class RoleController {

    private int count;
    private int rows;
    private int pageSize=5;   
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private DepartmentService departmentService;
    
    /*
     * 显示所有职位信息
     */
    @RequestMapping(value="/findAllRole")
    public String findAllRole(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model){
                
        rows = (pageNow - 1) * pageSize;
        count=roleService.findCountByCondition("","");
        List<RoleInfo> roleInfoList=roleService.findAllRole("","",rows,pageSize);
        if (roleInfoList!=null&&roleInfoList.size()>0) {
            model.addAttribute("roleInfoList", roleInfoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "role/roleList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /*
     * 根据职位名称和部门名称查询
     */
    @RequestMapping(value="/selectRole")
    public String selectRole(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("roleName") String roleName,Model model,
            @RequestParam("dpmName") String dpmName){
       
        rows = (pageNow - 1) * pageSize;
        count=roleService.findCountByCondition(roleName,dpmName);
        List<RoleInfo> roleInfoList=roleService.findAllRole(roleName,dpmName,rows,pageSize);
        if (roleInfoList!=null&&roleInfoList.size()>0) {
            model.addAttribute("roleName", roleName);
            model.addAttribute("dpmName", dpmName);
            model.addAttribute("roleInfoList", roleInfoList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "role/roleList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    // 跳转到职位添加页面
    @RequestMapping(value="/addRole")
    public String addRole(Model model){
        List<Department> dpmList=departmentService.findAllDepartments();
        model.addAttribute("dpmList", dpmList);
        return "role/roleAdd"; 
    }
    
    // 保存新添加的职位
    @RequestMapping(value="/saveRole")
    public String saveRole(Role role,@RequestParam("dpm") int dpmId){
        Department department=departmentService.finddpmById(dpmId);
        role.setDpmId(department);
        roleService.saveRole(role);
        return "redirect:findAllRole";
    }
    
    // 检查部门和职位是否同时重复
    @RequestMapping(value="/checkroleName")
    public void checkroleName(@RequestParam("roleName") String roleName,@RequestParam("dpmId") Integer dpmId,
            HttpServletResponse response,HttpServletRequest request) throws Exception{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        Role role=roleService.checkRoleName(roleName,dpmId);
        if (role==null) {
            out.print("可以添加");
        } else {
            out.print("该部门下已存在该职位");
        }
    }
    
    // 查找职位信息
    @RequestMapping(value="/findroleInfo")
    public String findroleInfo(@RequestParam("roleId") int roleId,Model model){
        RoleInfo roleInfo=roleService.findRoleById(roleId);
        if (roleInfo==null) {
            System.out.println("职位信息为空!");
            return "common/error";
        }else {
            model.addAttribute("roleInfo", roleInfo);
            return "role/roleUpdate";
        }   
    }
    
    // 更新职位信息
    @RequestMapping(value="/updateRole")
    public String updateRole(Role role){
        roleService.updateRole(role);
        return "redirect:findAllRole";
    }
    
    // 删除职位信息
    @RequestMapping(value="/deleteRole")
    public String deleteRole(@RequestParam("ids") String[] sids,HttpServletRequest request,HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        Integer[] ids=StrToInt.converterStringArray2IntegerArray(sids);
        List<Staff> staffList=staffService.findStaffByroleIds(ids);
        if (staffList==null||staffList.size()==0) {
            roleService.deleteRoleByIds(ids);
            return "redirect:findAllRole";
        } else {
            session.setAttribute("errorInfo","该职位下存在员工，无法删除!");
            session.setMaxInactiveInterval(1);
            return "redirect:findAllRole";          
        }  
    }
    
    // 根据部门id查询职位
    @RequestMapping(value="/selectRoleBydpmId")
    public void selectRoleBydpmId(@RequestParam("dpmId") int dpmId,HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Role> roleList=roleService.selectRoleBydpmId(dpmId);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(roleList);
        response.getWriter().append(json);
    }
    
    
}
