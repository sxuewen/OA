package cn.com.oa.pojo;

// 申请类型表
public class ApprovalType {
    private int appTypeId;  
    private String appTypeName;  // 申请表类型名
    private String description;  // 申请表描述
    
    public int getAppTypeId() {
        return appTypeId;
    }
    public void setAppTypeId(int appTypeId) {
        this.appTypeId = appTypeId;
    }
    public String getAppTypeName() {
        return appTypeName;
    }
    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
