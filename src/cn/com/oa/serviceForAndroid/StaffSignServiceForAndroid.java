package cn.com.oa.serviceForAndroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.StaffSignMapperForAndroid;
import cn.com.oa.pojo.StaffSign;


@Service
public class StaffSignServiceForAndroid {
	@Autowired
    private StaffSignMapperForAndroid staffSignMapperForAndroid;

  

	public int addStaffSign(StaffSign staffSign) {
		// TODO Auto-generated method stub
		return staffSignMapperForAndroid.addStaffSign(staffSign);
	}
	
	public int getWorkCount(){
		return staffSignMapperForAndroid.getWorkCount();
	}
	public int getRestCount(){
		return staffSignMapperForAndroid.getRestCount();
	}
	public int getLateCount(){
		return staffSignMapperForAndroid.getLateCount();
	}
	public int getBackCount(){
		return staffSignMapperForAndroid.getBackCount();
	}
	public int getLoseCount(){
		return staffSignMapperForAndroid.getLoseCount();
	}
	public int getAbsenceCount(){
		return staffSignMapperForAndroid.getAbsenceCount();
	}
	public int getOutsideCount(){
		return staffSignMapperForAndroid.getOutsideCount();
	}
	public int getAddWorkCount(){
		return staffSignMapperForAndroid.getAddWorkCount();
	}
}
