package cn.com.oa.pojo;

public class QingJiaApp {
     
    private String QJType;       // 请假类型（病假、伤假、产假、婚假、事假、丧假、其它）
    private String QJStartDay;   // 请假起始日期
    private String QJEndDay;     // 请假结束日期
    private String QJDays;       // 请假天数
    private String QJReason;     // 请假原因
    
    public String getQJType() {
        return QJType;
    }
    public void setQJType(String qJType) {
        QJType = qJType;
    }
    public String getQJReason() {
        return QJReason;
    }
    public void setQJReason(String qJReason) {
        QJReason = qJReason;
    }
    public String getQJStartDay() {
        return QJStartDay;
    }
    public void setQJStartDay(String qJStartDay) {
        QJStartDay = qJStartDay;
    }
    public String getQJEndDay() {
        return QJEndDay;
    }
    public void setQJEndDay(String qJEndDay) {
        QJEndDay = qJEndDay;
    }
    public String getQJDays() {
        return QJDays;
    }
    public void setQJDays(String qJDays) {
        QJDays = qJDays;
    }
    
}
