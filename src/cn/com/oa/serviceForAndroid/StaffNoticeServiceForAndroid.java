package cn.com.oa.serviceForAndroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.StaffNoticeMapperForAndroid;
import cn.com.oa.pojo.NoticeVo;


@Service
public class StaffNoticeServiceForAndroid {

    @Autowired
    private StaffNoticeMapperForAndroid staffNoticeMapperForAndroid;
    
    public int yesReadForAndroid(int notId,int sfId){
    	return staffNoticeMapperForAndroid.yesReadForAndroid(notId, sfId);
    }
    
    public NoticeVo selectIsYesRead(int notId,int sfId){
    	return staffNoticeMapperForAndroid.selectIsYesRead(notId, sfId);
    }
    
    
}
