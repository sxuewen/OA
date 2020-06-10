package cn.com.oa.pojo;

//  员工考勤表
public class StaffSign {

    private int id;
    private int sfId;             // 员工id
    private String signDate;      // 员工打卡日期（年月日）
    private String ssAMStartTime; // 上午开始打卡时间
    private String ssAMEndTime;   // 上午结束打卡时间
    private String ssPMStartTime; // 下午开始打卡时间
    private String ssPMEndTime;   // 下午结束打卡时间
    private String signFlag;      // 员工打卡标志（判断第几次打卡）
    private String isWork;        // 是否出勤（ 1:是，初始值为null）
    private String isRest;        // 是否休息（ 1:是，初始值为null）
    private String isLate;        // 是否迟到（ 1:是，初始值为null）
    private String isTooLate;     // 是否严重迟到（ 1:是，初始值为null）
    private String isBack;        // 是否早退（ 1:是，初始值为null）
    private String isLose;        // 是否缺卡（ 1:是，初始值为null）
    private String isAbsence;     // 是否旷工（ 1:是，初始值为null）
    private String isOutside;     // 是否外勤（ 1:是，初始值为null）
    private String isAddWork;     // 是否加班（ 1:是，初始值为null）
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSfId() {
        return sfId;
    }
    public void setSfId(int sfId) {
        this.sfId = sfId;
    }
    public String getSsAMStartTime() {
        return ssAMStartTime;
    }
    public void setSsAMStartTime(String ssAMStartTime) {
        this.ssAMStartTime = ssAMStartTime;
    }
    public String getSsAMEndTime() {
        return ssAMEndTime;
    }
    public void setSsAMEndTime(String ssAMEndTime) {
        this.ssAMEndTime = ssAMEndTime;
    }
    public String getSsPMStartTime() {
        return ssPMStartTime;
    }
    public void setSsPMStartTime(String ssPMStartTime) {
        this.ssPMStartTime = ssPMStartTime;
    }
    public String getSsPMEndTime() {
        return ssPMEndTime;
    }
    public void setSsPMEndTime(String ssPMEndTime) {
        this.ssPMEndTime = ssPMEndTime;
    }
    public String getSignFlag() {
        return signFlag;
    }
    public void setSignFlag(String signFlag) {
        this.signFlag = signFlag;
    }
    public String getIsWork() {
        return isWork;
    }
    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }
    public String getIsRest() {
        return isRest;
    }
    public void setIsRest(String isRest) {
        this.isRest = isRest;
    }
    public String getIsLate() {
        return isLate;
    }
    public void setIsLate(String isLate) {
        this.isLate = isLate;
    }
    public String getIsTooLate() {
        return isTooLate;
    }
    public void setIsTooLate(String isTooLate) {
        this.isTooLate = isTooLate;
    }
    public String getIsBack() {
        return isBack;
    }
    public void setIsBack(String isBack) {
        this.isBack = isBack;
    }
    public String getIsLose() {
        return isLose;
    }
    public void setIsLose(String isLose) {
        this.isLose = isLose;
    }
    public String getIsAbsence() {
        return isAbsence;
    }
    public void setIsAbsence(String isAbsence) {
        this.isAbsence = isAbsence;
    }
    public String getIsOutside() {
        return isOutside;
    }
    public void setIsOutside(String isOutside) {
        this.isOutside = isOutside;
    }
    public String getIsAddWork() {
        return isAddWork;
    }
    public void setIsAddWork(String isAddWork) {
        this.isAddWork = isAddWork;
    }
    public String getSignDate() {
        return signDate;
    }
    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }    
    
}
