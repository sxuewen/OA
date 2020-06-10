package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Role;
import cn.com.oa.pojo.RoleInfo;

public interface RoleMapper {

    public int findCountByCondition(String roleName,String dpmName);

    public List<RoleInfo> findAllRole(String roleName,String dpmName, int rows, int pageSize);

    public Role checkRoleName(String roleName,Integer dpmId);

    public void saveRole(Role role);

    public RoleInfo findRoleById(int roleId);

    public void updateRole(Role role);

    public void deleteRoleByIds(Integer[] ids);

    public List<Role> findAllRoles();

    public List<Role> findRoleBydpmIds(Integer[] ids);

    public Role findRoleInfoById(Integer roleId);

    public List<Role> selectRoleBydpmId(int dpmId);

    public int findCountBydpmId(int param);

}
