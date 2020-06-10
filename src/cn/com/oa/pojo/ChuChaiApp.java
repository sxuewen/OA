package cn.com.oa.pojo;

public class ChuChaiApp {
     
    private String CCStartDate;  // 出差起始日期（年月日）
    private String CCEndDate;    // 出差结束日期（年月日）
    private String CCDays;       // 出差天数
    private String CCPlace;      // 出差地点
    private String CCReason;     // 出差原因
    
    
    public String getCCStartDate() {
        return CCStartDate;
    }
    public void setCCStartDate(String cCStartDate) {
        CCStartDate = cCStartDate;
    }
    public String getCCEndDate() {
        return CCEndDate;
    }
    public void setCCEndDate(String cCEndDate) {
        CCEndDate = cCEndDate;
    }
    public String getCCPlace() {
        return CCPlace;
    }
    public void setCCPlace(String cCPlace) {
        CCPlace = cCPlace;
    }
    public String getCCReason() {
        return CCReason;
    }
    public void setCCReason(String cCReason) {
        CCReason = cCReason;
    }
    public String getCCDays() {
        return CCDays;
    }
    public void setCCDays(String cCDays) {
        CCDays = cCDays;
    }  
    
}
