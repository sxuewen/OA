package cn.com.oa.mapperForAndroid;

import cn.com.oa.pojo.NoticeVo;


public interface StaffNoticeMapperForAndroid {
    
    public int yesReadForAndroid(int notId,int sfId);
    
    public NoticeVo selectIsYesRead(int notId,int sfId); 

}
