package cn.com.oa.mapperForAndroid;

import cn.com.oa.pojo.StaffSign;

public interface StaffSignMapperForAndroid {
	public int addStaffSign(StaffSign staffSign);
	
	public int getWorkCount();
	public int getRestCount();
	public int getLateCount();
	public int getBackCount();
	public int getLoseCount();
	public int getAbsenceCount();
	public int getOutsideCount();
	public int getAddWorkCount();
	
}
