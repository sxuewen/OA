package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.StaffMapper;
import cn.com.oa.pojo.Staff;
import cn.com.oa.pojo.StaffInfo;

@Service
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;
    
    public Staff login(String userName, String password) {
        Staff staff=staffMapper.login(userName,password);
        return staff;
    }

    public List<Staff> findStaffByroleIds(Integer[] ids) {
        List<Staff> staffList=staffMapper.findStaffByroleIds(ids);
        return staffList;
    }

    public int findCount() {
        int count=staffMapper.findCount();
        return count;
    }

    public List<StaffInfo> findAllStaffInfo(int rows, int pageSize) {
        List<StaffInfo> staffList=staffMapper.findAllStaffInfo(rows,pageSize);
        return staffList;
    }

    public StaffInfo findStaffById(int sfId) {
        return staffMapper.findStaffById(sfId);
    }

    public int findCountByCondition(String sfUserName, String dpmName, String roleName) {
        int count=staffMapper.findCountByCondition(sfUserName,dpmName,roleName);
        return count;
    }

    public List<StaffInfo> findAllStaff(String sfUserName, String dpmName, String roleName, int rows,
            int pageSize) {
        List<StaffInfo> staffList=staffMapper.findAllStaff(sfUserName,dpmName,roleName,rows,pageSize);
        return staffList;
    }

    public Staff checksfUserName(String sfUserName) {        
        return staffMapper.checksfUserName(sfUserName);
    }

    public void saveStaff(Staff staff) {
        staffMapper.saveStaff(staff);
    }

    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    public void deleteStaffByIds(Integer[] ids) {
        staffMapper.deleteStaffByIds(ids);
    }

    public void savePersonalInfo(Staff staff) {
        staffMapper.savePersonalInfo(staff);
    }

    public int updatePassword(String newpsd, int sfId) {
         return staffMapper.updatePassword(newpsd,sfId);
		
    }

    public Staff findStaffBysfId(Integer sfId) {
        return staffMapper.findStaffBysfId(sfId);
    }

    public List<Staff> findStaffBydpmId(int dpmId) {
        List<Staff> staffList=staffMapper.findStaffBydpmId(dpmId);
        return staffList;
    }

}
