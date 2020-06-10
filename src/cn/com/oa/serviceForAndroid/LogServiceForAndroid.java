package cn.com.oa.serviceForAndroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.com.oa.mapperForAndroid.LogMapperForAndroid;
import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;


@Service
public class LogServiceForAndroid {

    @Autowired
    private LogMapperForAndroid logMapperForAndroid;

    public int addLog(Log log) {
    	return logMapperForAndroid.addLog(log);
    }
    
    public List<LogVo> selectlogBylogTypeForAndroid(int logType,int dpmId){
    	return logMapperForAndroid.selectlogBylogTypeForAndroid(logType, dpmId);
    }

    
    
}
