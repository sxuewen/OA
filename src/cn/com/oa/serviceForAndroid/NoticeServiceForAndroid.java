package cn.com.oa.serviceForAndroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.NoticeMapperForAndroid;
import cn.com.oa.pojo.NoticeVo;

@Service
public class NoticeServiceForAndroid {
	@Autowired
	private NoticeMapperForAndroid noticeMapperForAndroid;
	public List<NoticeVo> findAllNoticeForAndroid (){
    	return noticeMapperForAndroid.findAllNoticeForAndroid();
    }
	
}
