package cn.com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.PowerMapper;
import cn.com.oa.pojo.Power;

@Service
public class PowerService {

    @Autowired
    private PowerMapper powerMapper;
    
    public Power findPowerByCondition(int dpmLevel, int roleLevel) {
       Power power=powerMapper.findPowerByCondition(dpmLevel,roleLevel);
       return power;
    }

}
