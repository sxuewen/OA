package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Models;

public interface ModelsMapper {

    public List<Models> findModelByIds(String[] ids);

    public List<Models> findModelById(Integer id);

    public List<Models> findModelByParentId(String parentId);

    public Models findParentModelByParentId(Integer parentId);

}
