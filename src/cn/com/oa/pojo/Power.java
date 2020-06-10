package cn.com.oa.pojo;

//  权限表
public class Power {
    private int id;  // 主键
    private int dpmLevel;  // 所属部门等级
    private int roleLevel;  // 所属职位等级
    private String modelId;  // 对应模块
    private int Operation;  // 增删改查操作
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDpmLevel() {
        return dpmLevel;
    }
    public void setDpmLevel(int dpmLevel) {
        this.dpmLevel = dpmLevel;
    }
    public int getRoleLevel() {
        return roleLevel;
    }
    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }
    public String getModelId() {
        return modelId;
    }
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
    public int getOperation() {
        return Operation;
    }
    public void setOperation(int operation) {
        Operation = operation;
    }
    
    
}
