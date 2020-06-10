package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.DepartmentVo;

public interface DepartmentMapper {

    public int findCountByCondition(String param);

    public List<DepartmentVo> findAllDepartment(String param, int rows, int pageSize);

    public void saveDepartment(Department department);

    public Department checkdpmName(String dpmName);

    public Department finddpmById(int dpmId);

    public void updateDepartment(Department department);

    public void deleteDepartmentByIds(Integer[] ids);

    public List<Department> findAllDepartments();

    public int finddpmChildrenCount(int dpmId);

    public List<DepartmentVo> finddpmChildren(int dpmId, int rows, int pageSize);

    public List<DepartmentVo> findAllDepartment2(String param, int rows, int pageSize);

    public int findCountByConditionChild(String string, Integer parentId);

    public List<DepartmentVo> findAllDepartmentChild(String string, Integer parentId, int rows, int pageSize);

    public DepartmentVo finddpmVoById(int dpmId);

    public DepartmentVo findVoById(Integer dpmId);

    public List<Department> finddpmByIds(Integer[] ids);

    public int finddpmIdBydpmLevel(int i);

    public List<Department> findDpmNoParent();

    public List<Department> findChildrenBydpmId(int dpmId);

}
