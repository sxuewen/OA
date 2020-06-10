package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.LogMapper;
import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.LogVo;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public int findCount() {
        return logMapper.findCount();
    }

    public List<LogVo> findAllLog(int rows, int pageSize) {
        List<LogVo> logList=logMapper.findAllLog(rows,pageSize);
        return logList;
    }

    public LogVo findLogById(Integer logId) {
        return logMapper.findLogById(logId);
    }

    public void saveLog(Log log) {
        logMapper.saveLog(log);
    }

    public void updateLog(Log log) {
        logMapper.updateLog(log);
    }

    public int findCountByCondition(String logDate) {
        return logMapper.findCountByCondition(logDate);
    }

    public List<LogVo> findLogByCondition(String logDate, int rows, int pageSize) {
        List<LogVo> logList=logMapper.findLogByCondition(logDate,rows,pageSize);
        return logList;
    }

    public void deleteByIds(Integer[] ids) {
        logMapper.deleteByIds(ids);
    }

    public int findCountBydpmId(int dpmId,String param) {
        return logMapper.findCountBydpmId(dpmId,param);
    }

    public List<LogVo> findLogBydpmId(int dpmId,String param, int rows, int pageSize) {
        List<LogVo> logVoList=logMapper.findLogBydpmId(dpmId,param,rows,pageSize);
        return logVoList;
    }
    
    
}
