package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.DepartmentMapper;
import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.DepartmentVo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    
    public int findCountByCondition(String param) {
        int count=departmentMapper.findCountByCondition(param);
        return count;
    }

    public List<DepartmentVo> findAllDepartment(String param, int rows, int pageSize) {
        List<DepartmentVo> dpmList=departmentMapper.findAllDepartment(param,rows,pageSize);
        return dpmList;
    }

    public void saveDepartment(Department department) {
        departmentMapper.saveDepartment(department);        
    }

    public Department checkdpmName(String dpmName) {
        return departmentMapper.checkdpmName(dpmName);      
    }

    public Department finddpmById(int dpmId) {
        return departmentMapper.finddpmById(dpmId);
    }

    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);    
    }

    public void deleteDepartmentByIds(Integer[] ids) {
        departmentMapper.deleteDepartmentByIds(ids);
    }

    public List<Department> findAllDepartments() {
        List<Department> dpmList=departmentMapper.findAllDepartments();
        return dpmList;
    }

    public int finddpmChildrenCount(int dpmId) {
        return departmentMapper.finddpmChildrenCount(dpmId);
    }

    public List<DepartmentVo> finddpmChildren(int dpmId, int rows, int pageSize) {
        List<DepartmentVo> dpmList=departmentMapper.finddpmChildren(dpmId,rows,pageSize);
        return dpmList;
    }

    public List<DepartmentVo> findAllDepartment2(String param, int rows, int pageSize) {
        List<DepartmentVo> dpmList=departmentMapper.findAllDepartment2(param,rows,pageSize);
        return dpmList;
    }

    public int findCountByConditionChild(String string, Integer parentId) {     
        return departmentMapper.findCountByConditionChild(string,parentId);
    }

    public List<DepartmentVo> findAllDepartmentChild(String string, Integer parentId, int rows, int pageSize) {
        List<DepartmentVo> dpmList=departmentMapper.findAllDepartmentChild(string,parentId,rows,pageSize);
        return dpmList;
    }

    public DepartmentVo finddpmVoById(int dpmId) {
        return departmentMapper.finddpmVoById(dpmId);
    }

    public DepartmentVo findVoById(Integer dpmId) {      
        return departmentMapper.findVoById(dpmId);
    }

    public List<Department> finddpmByIds(Integer[] ids) {
        return departmentMapper.finddpmByIds(ids);
    }

    public int finddpmIdBydpmLevel(int i) {
        return departmentMapper.finddpmIdBydpmLevel(i);
    }

    public List<Department> findDpmNoParent() {
        List<Department> dpmList=departmentMapper.findDpmNoParent();
        return dpmList;
    }

    public List<Department> findChildrenBydpmId(int dpmId) {
        List<Department> dpmList=departmentMapper.findChildrenBydpmId(dpmId);
        return dpmList;
    }

}
