package cn.com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.StaffNoticeMapper;
import cn.com.oa.pojo.StaffNotice;

@Service
public class StaffNoticeService {

    @Autowired
    private StaffNoticeMapper staffNoticeMapper;

    public void addStaffNotice(StaffNotice staffNotice) {
        staffNoticeMapper.addStaffNotice(staffNotice);
    }

    public StaffNotice findNoticeBysfAndnot(int sfId, int notId) {
        return staffNoticeMapper.findNoticeBysfAndnot(sfId,notId);
    }
    
    
}
