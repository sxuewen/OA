package cn.com.oa.serviceForAndroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.DepartmentMapperForAndroid;
import cn.com.oa.pojo.Department;

@Service
public class DepartmentServiceForAndroid {
	@Autowired
	private DepartmentMapperForAndroid departmentMapperForAndroid;
	
	public List<Department> selectFirstDepartment(){
		return departmentMapperForAndroid.selectFirstDepartment();
	}
	public List<Department> selectSecondDepartment(Integer parentId){
		return departmentMapperForAndroid.selectSecondDepartment(parentId);
	}

}
