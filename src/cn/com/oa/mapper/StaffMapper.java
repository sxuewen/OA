package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffInfo;

public interface StaffMapper {

    public Staff login(String userName, String password);

    public List<Staff> findStaffByroleIds(Integer[] ids);

    public int findCount();

    public List<StaffInfo> findAllStaffInfo(int rows, int pageSize);

    public StaffInfo findStaffById(int sfId);

    public int findCountByCondition(String sfUserName, String dpmName, String roleName);

    public List<StaffInfo> findAllStaff(String sfUserName, String dpmName, String roleName, int rows, int pageSize);

    public Staff checksfUserName(String sfUserName);

    public void saveStaff(Staff staff);

    public void updateStaff(Staff staff);

    public void deleteStaffByIds(Integer[] ids);

    public void savePersonalInfo(Staff staff);

    public int updatePassword(String newpsd, int sfId);

    public Staff findStaffBysfId(Integer sfId);

    public List<Staff> findStaffBydpmId(int dpmId);
	
}
