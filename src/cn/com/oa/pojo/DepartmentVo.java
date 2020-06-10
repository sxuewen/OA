package cn.com.oa.pojo;

public class DepartmentVo {

    private int dpmId;  // 主键
    private String dpmName;  // 部门名称
    private String dpmDescription;  // 部门描述
    private String dpmCreatDate;  // 部门创建日期   
    private int dpmLevel;  // 部门等级
    private int parentId;  // 父部门id
    private String parentName;  // 父部门名称
    
    public int getDpmId() {
        return dpmId;
    }
    public void setDpmId(int dpmId) {
        this.dpmId = dpmId;
    }
    public String getDpmName() {
        return dpmName;
    }
    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }
    public String getDpmDescription() {
        return dpmDescription;
    }
    public void setDpmDescription(String dpmDescription) {
        this.dpmDescription = dpmDescription;
    }
    public String getDpmCreatDate() {
        return dpmCreatDate;
    }
    public void setDpmCreatDate(String dpmCreatDate) {
        this.dpmCreatDate = dpmCreatDate;
    }
    public int getDpmLevel() {
        return dpmLevel;
    }
    public void setDpmLevel(int dpmLevel) {
        this.dpmLevel = dpmLevel;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
   
}
