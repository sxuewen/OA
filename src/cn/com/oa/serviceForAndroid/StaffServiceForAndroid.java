package cn.com.oa.serviceForAndroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.StaffMapperForAndroid;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffDateBase;
import cn.com.oa.pojo.StaffInfo;
import cn.com.oa.pojo.StaffMoreProperty;

@Service
public class StaffServiceForAndroid {
	@Autowired
	private StaffMapperForAndroid staffMapperForAndroid;
	
	public StaffMoreProperty getStaffByNameAndPassword(String sfUserName, String sfPassword) {
		StaffMoreProperty staffMoreProperty=staffMapperForAndroid.getStaffByNameAndPassword(sfUserName, sfPassword);
        return staffMoreProperty;
    }
	
	public StaffInfo findStaffById(int sfId) {
        return staffMapperForAndroid.findStaffById(sfId);
    }
	
	public List<StaffDateBase> findStaffByDpmId(int dpmId){
		return staffMapperForAndroid.findStaffByDpmId(dpmId);
	}
	
	public List<StaffInfo> selectAllStaff(){
    	return staffMapperForAndroid.selectAllStaff();
    }
	
	public int updateSex(String sfSex,int sfId){
		return staffMapperForAndroid.updateSex(sfSex, sfId);
	}
	
	public int updatePhone(String sfPhone,int sfId){
		return staffMapperForAndroid.updatePhone(sfPhone, sfId);
	}
	
	public int updateAddress(String sfAddress,int sfId){
		return staffMapperForAndroid.updateAddress(sfAddress, sfId);
	}
	
	public int updateEmail(String sfEmail,int sfId){
		return staffMapperForAndroid.updateEmail(sfEmail, sfId);
	}

}
