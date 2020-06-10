package cn.com.oa.mapper;

import cn.com.oa.pojo.StaffNotice;

public interface StaffNoticeMapper {

    public void addStaffNotice(StaffNotice staffNotice);

    public StaffNotice findNoticeBysfAndnot(int sfId, int notId);

}
