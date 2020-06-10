package cn.com.oa.mapperForAndroid;

import java.util.List;

import cn.com.oa.pojo.Department;

public interface DepartmentMapperForAndroid {
	public List<Department> selectFirstDepartment();
	public List<Department> selectSecondDepartment(Integer parentId);

}
