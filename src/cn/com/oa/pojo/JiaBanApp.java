package cn.com.oa.pojo;

public class JiaBanApp {

    private String JBTip;        // 加班时段（工作日，双休日，节假日）
    private String JBStartTime;  // 加班开始时间（年月日时分）
    private String JBEndTime;    // 加班结束时间（年月日时分）
    private String JBTime;       // 加班时长（x小时x分钟）
    private String JBReason;     // 加班原因
    private String JBContent;    // 加班内容
    
    public String getJBTip() {
        return JBTip;
    }
    public void setJBTip(String jBTip) {
        JBTip = jBTip;
    }
    public String getJBStartTime() {
        return JBStartTime;
    }
    public void setJBStartTime(String jBStartTime) {
        JBStartTime = jBStartTime;
    }
    public String getJBEndTime() {
        return JBEndTime;
    }
    public void setJBEndTime(String jBEndTime) {
        JBEndTime = jBEndTime;
    }
    public String getJBReason() {
        return JBReason;
    }
    public void setJBReason(String jBReason) {
        JBReason = jBReason;
    }
    public String getJBContent() {
        return JBContent;
    }
    public void setJBContent(String jBContent) {
        JBContent = jBContent;
    }
    public String getJBTime() {
        return JBTime;
    }
    public void setJBTime(String jBTime) {
        JBTime = jBTime;
    }
    
    
}
