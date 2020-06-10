package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.ApprovalTypeMapper;
import cn.com.oa.pojo.ApprovalType;

@Service
public class ApprovalTypeService {

    @Autowired
    private ApprovalTypeMapper appTypeMapper;
    
    public List<ApprovalType> findAppTypes() {
        List<ApprovalType> appTypeList=appTypeMapper.findAppTypes();
        return appTypeList;
    }

}
