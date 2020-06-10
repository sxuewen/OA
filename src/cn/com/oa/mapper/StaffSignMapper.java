package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.StaffSign;

public interface StaffSignMapper {

    public List<StaffSign> findSignWithCurrent(int sfId, String currentDate);

    public List<StaffSign> findSignWithSixMonth(int sfId, String firstDay, String lastDay);

    
}
