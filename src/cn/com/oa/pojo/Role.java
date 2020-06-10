package cn.com.oa.pojo;

// 职位表
public class Role {

    private int roleId;  // 主键
    private String roleName;  // 职位名称
    private String roleDescription;  // 职位描述
    private Department dpmId;  // 所属部门
    private int roleLevel;     // 职位等级
    
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDescription() {
        return roleDescription;
    }
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    public Department getDpmId() {
        return dpmId;
    }
    public void setDpmId(Department dpmId) {
        this.dpmId = dpmId;
    }
    public int getRoleLevel() {
        return roleLevel;
    }
    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }
    
}
