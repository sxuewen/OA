package cn.com.oa.mapper;

import cn.com.oa.pojo.Power;

public interface PowerMapper {

    public Power findPowerByCondition(int dpmLevel, int roleLevel);

}
