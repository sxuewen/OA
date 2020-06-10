package cn.com.oa.pojo;

// 公告表
public class Notice {
    private int notId;   // 主键
    private String notTitle;   // 公告标题
    private String notContent; // 公告内容
    private String notDate;    // 发布时间
    private String adminName;  // 发布人
    
    public int getNotId() {
        return notId;
    }
    public void setNotId(int notId) {
        this.notId = notId;
    }
    public String getNotTitle() {
        return notTitle;
    }
    public void setNotTitle(String notTitle) {
        this.notTitle = notTitle;
    }
    public String getNotContent() {
        return notContent;
    }
    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }
    public String getNotDate() {
        return notDate;
    }
    public void setNotDate(String notDate) {
        this.notDate = notDate;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    
}
