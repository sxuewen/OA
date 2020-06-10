package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.RoleMapper;
import cn.com.oa.pojo.Role;
import cn.com.oa.pojo.RoleInfo;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    
    public int findCountByCondition(String roleName,String dpmName) {
        int count=roleMapper.findCountByCondition(roleName,dpmName);
        return count;
    }

    public List<RoleInfo> findAllRole(String roleName,String dpmName, int rows, int pageSize) {
        List<RoleInfo> roleInfoList=roleMapper.findAllRole(roleName,dpmName,rows,pageSize);
        return roleInfoList;
    }

    public Role checkRoleName(String roleName,Integer dpmId) {
        return roleMapper.checkRoleName(roleName,dpmId);
    }

    public void saveRole(Role role) {
        roleMapper.saveRole(role);
    }

    public RoleInfo findRoleById(int roleId) {
        return roleMapper.findRoleById(roleId);
    }

    public void updateRole(Role role) {
        roleMapper.updateRole(role);     
    }

    public void deleteRoleByIds(Integer[] ids) {
        roleMapper.deleteRoleByIds(ids);
    }

    public List<Role> findAllRoles() {
        List<Role> roleList=roleMapper.findAllRoles();
        return roleList;
    }

    public List<Role> findRoleBydpmIds(Integer[] ids) {
        List<Role> roleList= roleMapper.findRoleBydpmIds(ids);
        return roleList;
    }

    public Role findRoleInfoById(Integer roleId) {
        return roleMapper.findRoleInfoById(roleId);
    }

    public List<Role> selectRoleBydpmId(int dpmId) {
        List<Role> roleList=roleMapper.selectRoleBydpmId(dpmId);
        return roleList;
    }

    public int findCountBydpmId(int param) {
        return roleMapper.findCountBydpmId(param);
    }

}
