package cn.com.oa.pojo;

//  考勤表
public class Sign {

    private int signId;  
    private String signPlace;    // 打卡地点    
    private String longitude;    // 打卡地理位置（经度）
    private String latitude;     // 打卡地理位置（纬度）
    private double meter;        // 打卡范围 （300米）
    private String signDate;     // 规则开始生效日期（自动生成，年月日时分秒）
    private String amStartTime;  // 上午开始打卡时间（时分）
    private String amEndTime;    // 上午结束打卡时间（时分）
    private String pmStartTime;  // 下午开始打卡时间（时分）
    private String pmEndTime;    // 下午结束打卡时间（时分）
    private String lateTime;     // 迟到规则设置（<=10分钟）
    private String tooLateTime;  // 严重迟到规则设置（<=1小时）
    private String absenceTime;  // 旷工规则设置（>=2小时）
    
    public int getSignId() {
        return signId;
    }
    public void setSignId(int signId) {
        this.signId = signId;
    }
    public String getSignPlace() {
        return signPlace;
    }
    public void setSignPlace(String signPlace) {
        this.signPlace = signPlace;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public double getMeter() {
        return meter;
    }
    public void setMeter(double meter) {
        this.meter = meter;
    }
    public String getSignDate() {
        return signDate;
    }
    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }
    public String getAmStartTime() {
        return amStartTime;
    }
    public void setAmStartTime(String amStartTime) {
        this.amStartTime = amStartTime;
    }
    public String getAmEndTime() {
        return amEndTime;
    }
    public void setAmEndTime(String amEndTime) {
        this.amEndTime = amEndTime;
    }
    public String getPmStartTime() {
        return pmStartTime;
    }
    public void setPmStartTime(String pmStartTime) {
        this.pmStartTime = pmStartTime;
    }
    public String getPmEndTime() {
        return pmEndTime;
    }
    public void setPmEndTime(String pmEndTime) {
        this.pmEndTime = pmEndTime;
    }
    public String getLateTime() {
        return lateTime;
    }
    public void setLateTime(String lateTime) {
        this.lateTime = lateTime;
    }
    public String getTooLateTime() {
        return tooLateTime;
    }
    public void setTooLateTime(String tooLateTime) {
        this.tooLateTime = tooLateTime;
    }
    public String getAbsenceTime() {
        return absenceTime;
    }
    public void setAbsenceTime(String absenceTime) {
        this.absenceTime = absenceTime;
    }
    
       
}
