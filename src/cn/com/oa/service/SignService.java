package cn.com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.SignMapper;
import cn.com.oa.pojo.Sign;

@Service
public class SignService {

    @Autowired
    private SignMapper signMapper;

    public Sign findSign() {
        return signMapper.findSign();
    }

    public void updateSign(Sign sign) {
        signMapper.updateSign(sign);
    }
    
    
    
}
