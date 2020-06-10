package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;

public interface LogMapper {

    public int findCount();

    public List<LogVo> findAllLog(int rows, int pageSize);

    public LogVo findLogById(Integer logId);

    public void saveLog(Log log);

    public void updateLog(Log log);

    public int findCountByCondition(String logDate);

    public List<LogVo> findLogByCondition(String logDate, int rows, int pageSize);

    public void deleteByIds(Integer[] ids);

    public int findCountBydpmId(int dpmId,String param);

    public List<LogVo> findLogBydpmId(int dpmId,String param, int rows, int pageSize);


}
