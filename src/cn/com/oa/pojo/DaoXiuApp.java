package cn.com.oa.pojo;

public class DaoXiuApp {

    private String DXStartDate;     // 倒休起始日期（年月日）
    private String DXEndDate;       // 倒休结束日期（年月日）
    private String DXDays;          // 倒休天数
    private String DXWorkStartDate; // 补班起始日期（年月日）
    private String DXWorkEndDate;   // 补班结束日期（年月日）
    private String DXWorkDays;      // 补班天数
    private String DXReason;        // 倒休原因
    
    public String getDXStartDate() {
        return DXStartDate;
    }
    public void setDXStartDate(String dXStartDate) {
        DXStartDate = dXStartDate;
    }
    public String getDXEndDate() {
        return DXEndDate;
    }
    public void setDXEndDate(String dXEndDate) {
        DXEndDate = dXEndDate;
    }
    public String getDXWorkStartDate() {
        return DXWorkStartDate;
    }
    public void setDXWorkStartDate(String dXWorkStartDate) {
        DXWorkStartDate = dXWorkStartDate;
    }
    public String getDXWorkEndDate() {
        return DXWorkEndDate;
    }
    public void setDXWorkEndDate(String dXWorkEndDate) {
        DXWorkEndDate = dXWorkEndDate;
    }
    public String getDXReason() {
        return DXReason;
    }
    public void setDXReason(String dXReason) {
        DXReason = dXReason;
    }
    public String getDXDays() {
        return DXDays;
    }
    public void setDXDays(String dXDays) {
        DXDays = dXDays;
    }
    public String getDXWorkDays() {
        return DXWorkDays;
    }
    public void setDXWorkDays(String dXWorkDays) {
        DXWorkDays = dXWorkDays;
    }    
    
}
