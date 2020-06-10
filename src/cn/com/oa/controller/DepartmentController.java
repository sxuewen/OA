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
import cn.com.oa.pojo.DepartmentVo;
import cn.com.oa.pojo.Role;
import cn.com.oa.service.DepartmentService;
import cn.com.oa.service.RoleService;
import cn.com.oa.service.StaffService;
import cn.com.oa.util.PageBean;
import cn.com.oa.util.StrToInt;

@RequestMapping("department")
@Controller
public class DepartmentController {

    private int count;
    private int rows;
    private int pageSize=5;    
        
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private StaffService staffService;
    
    
    /*
     * 显示所有父部门信息
     */
    @RequestMapping(value="/findAllDepartment")
    public String findAllDepartment(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,Model model){
              
        rows = (pageNow - 1) * pageSize;
        count=departmentService.findCountByCondition("");
        List<DepartmentVo> dpmList=departmentService.findAllDepartment("",rows,pageSize);
        
        if (dpmList!=null&&dpmList.size()>0) {
            model.addAttribute("dpmList", dpmList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    
    /*
     * 根据父部门名称查询
     */
    @RequestMapping(value="/selectDepartment")
    public String selectDepartment(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("dpmName") String dpmName,Model model){
       
        rows = (pageNow - 1) * pageSize;
        count=departmentService.findCountByCondition(dpmName);
        List<DepartmentVo> dpmList=departmentService.findAllDepartment(dpmName,rows,pageSize);
        if (dpmList!=null&&dpmList.size()>0) {
            model.addAttribute("dpmName", dpmName);
            model.addAttribute("dpmList", dpmList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 子部门模糊查询
     */
    @RequestMapping(value="/selectDepartment2")
    public String selectDepartment2(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
           @RequestParam("dpmName") String dpmName,@RequestParam("parentId") Integer parentId,Model model){
       
        rows = (pageNow - 1) * pageSize;
        count=departmentService.findCountByConditionChild(dpmName, parentId);
        List<DepartmentVo> dpmList=departmentService.findAllDepartmentChild(dpmName, parentId, rows, pageSize);
        if (dpmList!=null&&dpmList.size()>0) {
            model.addAttribute("parentId", parentId);
            model.addAttribute("dpmName", dpmName);
            model.addAttribute("dpmList", dpmList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList2";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 
     * 分页查询子部门（无条件）
     */
    @RequestMapping(value="/findDepartmentByPage")
    public String findDepartmentByPage(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam("parentId") Integer parentId,Model model){
       
        rows = (pageNow - 1) * pageSize;
        count=departmentService.findCountByConditionChild("",parentId);
        List<DepartmentVo> dpmList=departmentService.findAllDepartmentChild("",parentId,rows,pageSize);
        if (dpmList!=null&&dpmList.size()>0) {
            model.addAttribute("parentId", parentId);
            model.addAttribute("dpmList", dpmList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList2";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    /**
     * 
     * 分页查询子部门（有条件）
     */
    @RequestMapping(value="/findDepartmentByPage2")
    public String findDepartmentByPage2(@RequestParam(value="pageNow",defaultValue="1") Integer pageNow,
            @RequestParam(value="dpmName") String dpmName,@RequestParam("parentId") Integer parentId,Model model){
       
        rows = (pageNow - 1) * pageSize;
        count=departmentService.findCountByCondition(dpmName);
        List<DepartmentVo> dpmList=departmentService.findAllDepartment2(dpmName,rows,pageSize);
        if (dpmList!=null&&dpmList.size()>0) {
            model.addAttribute("parentId", parentId);
            model.addAttribute("dpmName", dpmName);
            model.addAttribute("dpmList", dpmList);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList2";
        }else {
            System.out.println("暂无数据!");
            return "common/error";
        }
    }
    
    // 跳转到部门添加页面
    @RequestMapping(value="/addDepartment")
    public String addDepartment(@RequestParam("parentId") Integer parentId,Model model){
        System.out.println("父类Id:"+parentId);
        if (parentId!=null) {
            Department dpmDepartment=departmentService.finddpmById(parentId);
            model.addAttribute("dpmName", dpmDepartment.getDpmName());
        }    
        model.addAttribute("parentId", parentId);        
        return "department/departmentAdd"; 
    }
    
    // 保存新添加的部门
    @RequestMapping(value="/saveDepartment")
    public String saveDepartment(Department department,@RequestParam("parentId") Integer parentId){
        if (parentId!=null) {
            Department dpm=departmentService.finddpmById(parentId);
            department.setParent(dpm);
            departmentService.saveDepartment(department);
            return "redirect:finddpmChildren?dpmId="+parentId;
        }else {
            departmentService.saveDepartment(department);
            return "redirect:findAllDepartment";
        }            
       
    }
    
    // 检查部门名称是否重复
    @RequestMapping(value="/checkdpmName")
    public void checkdpmName(@RequestParam("dpmName") String dpmName,HttpServletResponse response,HttpServletRequest request) throws Exception{
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        Department department=departmentService.checkdpmName(dpmName);
        if (department==null) {
            out.print("可以使用");
        } else {
            out.print("已存在");
        }
    }
    
    // 部门信息修改页面
    @RequestMapping(value="/finddpmInfo")
    public String finddpmInfo(@RequestParam("dpmId") Integer dpmId,
            @RequestParam("parentId") Integer parentId,Model model){
        
        if (parentId==null||parentId==0) {
            DepartmentVo departmentVo=departmentService.findVoById(dpmId);
            System.out.println(departmentVo.getParentId());
            model.addAttribute("dpmInfo", departmentVo);
            return "department/departmentUpdate";
        }else {
            DepartmentVo departmentVo=departmentService.finddpmVoById(dpmId);
            model.addAttribute("dpmInfo", departmentVo);
            return "department/departmentUpdate";
        }      
        /*if (department==null) {
            System.out.println("部门信息为空!");
            return "common/error";
        }else {*/
        //  model.addAttribute("dpmInfo", departmentVo);          
    }
    
    //  查找该部门的子部门
    @RequestMapping(value="/finddpmChildren")
    public String finddpmChildren(@RequestParam("dpmId") int dpmId,Model model,
            @RequestParam(value="pageNow",defaultValue="1") Integer pageNow){
        
        rows = (pageNow - 1) * pageSize;
        count=departmentService.finddpmChildrenCount(dpmId);
        List<DepartmentVo> dpmChildren=departmentService.finddpmChildren(dpmId,rows,pageSize);
        
      //  System.out.println(dpmChildren.get(0).getParentName());
        
        if (dpmChildren!=null&&dpmChildren.size()>0) {
            model.addAttribute("parentId", dpmChildren.get(0).getParentId());
            model.addAttribute("dpmList", dpmChildren);
       //   model.addAttribute("dpmParentName", dpmName);
            PageBean page=new PageBean(pageNow, count, pageSize);
            model.addAttribute("page", page);
            return "department/departmentList2";
        }else {
            model.addAttribute("parentId", dpmId);
            System.out.println("暂无数据!");
            return "department/departmentList2";
        }      
        
    }
    
    // 更新部门信息
    @RequestMapping(value="/updateDepartment")
    public String updateDepartment(Department department,@RequestParam("parentId") Integer parentId){
        if (parentId==null||parentId==0) {            
            departmentService.updateDepartment(department);
            return "redirect:findAllDepartment";
        }else {
            departmentService.updateDepartment(department);
            return "redirect:finddpmChildren?dpmId="+parentId;
        }             
    }
    
    // 删除部门信息
    @RequestMapping(value="/deleteDepartment")
    public String deleteDepartment(@RequestParam("ids") String[] sids,HttpServletRequest request,
            HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        Integer[] ids=StrToInt.converterStringArray2IntegerArray(sids);
        
        List<Role> roleList=roleService.findRoleBydpmIds(ids);
        List<Department> dpmList=departmentService.finddpmByIds(ids);
        if ((roleList==null||roleList.size()==0)&&(dpmList==null||dpmList.size()==0)) {
            departmentService.deleteDepartmentByIds(ids);
            return "redirect:findAllDepartment";
        } else {
            session.setAttribute("errorInfo","该部门下存在职位，无法删除!");
            session.setMaxInactiveInterval(1);
            return "redirect:findAllDepartment";          
        }  
    }
    
}
