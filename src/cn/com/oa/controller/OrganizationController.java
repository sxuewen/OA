package cn.com.oa.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.Organization;
import cn.com.oa.pojo.Staff;
import cn.com.oa.service.DepartmentService;
import cn.com.oa.service.StaffService;

@RequestMapping("/organization")
@Controller
public class OrganizationController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StaffService staffService;
    
    
    @RequestMapping(value="/findOrganization")
    public String findOrganization(){
        return "organization/organizationList";
    }

       
    @RequestMapping(value = "/organizationList")
    @ResponseBody
    public Organization organizationList() {
        
        List<Organization> organizationList1 = new ArrayList<Organization>();  // 封装父部门数据        
        List<Organization> organizationList3 = new ArrayList<Organization>();  // 封装子部门员工数据          
        List<Department> dpmParentList = departmentService.findDpmNoParent(); // 查询所有父部门
                
        for (int i = 0; i < dpmParentList.size(); i++) { // 遍历父部门                       
            List<Department> dpmChildList = departmentService.findChildrenBydpmId(dpmParentList.get(i).getDpmId());
            List<Staff> staffList=staffService.findStaffBydpmId(dpmParentList.get(i).getDpmId());            
            List<Organization> organizationList2 = new ArrayList<Organization>();  // 封装子部门数据
            
            if (dpmChildList != null && dpmChildList.size() > 0) {   // 子部门不为空                               
                for (int j = 0; j < dpmChildList.size(); j++) {      // 遍历子部门
                                        
                    List<Staff> staffList2=staffService.findStaffBydpmId(dpmChildList.get(j).getDpmId());                                        
                    for (int k = 0; k < staffList2.size(); k++) {  // 遍历员工                   
                        Organization organization3=new Organization();
                        organization3.setName(staffList2.get(k).getSfRealName());
                        organization3.setUrl("staff/findStaffById?sfId="+staffList2.get(k).getSfId());
                        organization3.setContents(null);
                        organizationList3.add(organization3);
                    }
                    Organization organization2=new Organization();
                    organization2.setName(dpmChildList.get(j).getDpmName());
                    organization2.setUrl(null);
                    organization2.setContents(organizationList3);
                    organizationList2.add(organization2);                    
                 }                                 
              } 
              if (staffList!=null&&staffList.size()>0) {                              
                 for (int l = 0; l < staffList.size(); l++) {
                     Organization organization2=new Organization();
                     organization2.setName(staffList.get(l).getSfRealName());
                     organization2.setUrl("staff/findStaffById?sfId="+staffList.get(l).getSfId());
                     organization2.setContents(null);
                     organizationList2.add(organization2);                    
                 }                
              }
              Organization organization1=new Organization();
              organization1.setName(dpmParentList.get(i).getDpmName());
              organization1.setUrl(null);
              organization1.setContents(organizationList2);
              organizationList1.add(organization1);             
        }

        Organization organization=new Organization();
        organization.setName("小源集团");
        organization.setUrl(null);
        organization.setContents(organizationList1);
        
        return organization;
    }

}
