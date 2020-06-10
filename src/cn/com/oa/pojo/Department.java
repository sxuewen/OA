package cn.com.oa.pojo;

// 部门表
public class Department {

    private int dpmId;       
    private String dpmName;         // 部门名称
    private String dpmDescription;  // 部门描述
    private String dpmCreatDate;    // 部门创建日期   
    private int dpmLevel;           // 部门等级
    private Department parent;      // 父部门  
    
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
    public Department getParent() {
        return parent;
    }
    public void setParent(Department parent) {
        this.parent = parent;
    }
    
}
