package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.StaffSignMapper;
import cn.com.oa.pojo.StaffSign;

@Service
public class StaffSignService {

    @Autowired
    private StaffSignMapper staffSignMapper;

    public List<StaffSign> findSignWithCurrent(int sfId, String currentDate) {
        List<StaffSign> staffSignList=staffSignMapper.findSignWithCurrent(sfId,currentDate);
        return staffSignList;
    }

    public List<StaffSign> findSignWithSixMonth(int sfId, String firstDay, String lastDay) {
        List<StaffSign> staffSignList=staffSignMapper.findSignWithSixMonth(sfId,firstDay,lastDay);
        return staffSignList;
    }
    
    
    
}
