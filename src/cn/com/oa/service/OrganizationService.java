package cn.com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.OrganizationMapper;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;
    
    
    
}
