package cn.com.oa.mapperForAndroid;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffDateBase;
import cn.com.oa.pojo.StaffInfo;
import cn.com.oa.pojo.StaffMoreProperty;

public interface StaffMapperForAndroid {
	
	public StaffMoreProperty getStaffByNameAndPassword(String userName, String password);
	public StaffInfo findStaffById(int sfId);
	public List<StaffDateBase> findStaffByDpmId(int dpmId);
	public List<StaffInfo> selectAllStaff();
	public int updateSex(@Param(value="sfSex")String sfSex,@Param(value="sfId")int sfId);
	public int updatePhone(@Param(value="sfPhone")String sfPhone,@Param(value="sfId")int sfId);
	public int updateAddress(@Param(value="sfAddress")String sfAddress,@Param(value="sfId")int sfId);
	public int updateEmail(@Param(value="sfEmail")String sfEmail,@Param(value="sfId")int sfId);


}
