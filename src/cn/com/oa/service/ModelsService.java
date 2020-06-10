package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.ModelsMapper;
import cn.com.oa.pojo.Models;

@Service
public class ModelsService {

    @Autowired
    private ModelsMapper modelMapper;
    
    public List<Models> findModelByIds(String[] ids) {
        List<Models> list=modelMapper.findModelByIds(ids);
        return list;
    }

    public List<Models> findModelById(Integer id) {
        List<Models> list=modelMapper.findModelById(id);
        return list;
    }

    public List<Models> findModelByParentId(String parentId) {
        List<Models> list=modelMapper.findModelByParentId(parentId);
        return list;
    }

    public Models findParentModelByParentId(Integer parentId) {
        return modelMapper.findParentModelByParentId(parentId);
    }

}
