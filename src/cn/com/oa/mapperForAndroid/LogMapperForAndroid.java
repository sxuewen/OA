package cn.com.oa.mapperForAndroid;

import java.util.List;

import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;

public interface LogMapperForAndroid {

    public int addLog(Log log);
    public List<LogVo> selectlogBylogTypeForAndroid(int logType,int dpmId);

}
