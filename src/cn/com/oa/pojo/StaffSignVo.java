package cn.com.oa.pojo;

public class StaffSignVo {

    private String during;     // 日期段（年月/年月~年月）
    private int workCount;     // 出勤次数
    private int restCount;     // 休息次数
    private int lateCount;     // 迟到次数
    private int backCount;     // 早退次数
    private int loseCount;     // 缺卡次数
    private int absenceCount;  // 旷工次数
    private int outsideCount;  // 外勤次数
    private int addWorkCount;  // 加班次数
    
    
    public String getDuring() {
        return during;
    }
    public void setDuring(String during) {
        this.during = during;
    }
    public int getWorkCount() {
        return workCount;
    }
    public void setWorkCount(int workCount) {
        this.workCount = workCount;
    }
    public int getRestCount() {
        return restCount;
    }
    public void setRestCount(int restCount) {
        this.restCount = restCount;
    }
    public int getLateCount() {
        return lateCount;
    }
    public void setLateCount(int lateCount) {
        this.lateCount = lateCount;
    }
    public int getBackCount() {
        return backCount;
    }
    public void setBackCount(int backCount) {
        this.backCount = backCount;
    }
    public int getLoseCount() {
        return loseCount;
    }
    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }
    public int getAbsenceCount() {
        return absenceCount;
    }
    public void setAbsenceCount(int absenceCount) {
        this.absenceCount = absenceCount;
    }
    public int getOutsideCount() {
        return outsideCount;
    }
    public void setOutsideCount(int outsideCount) {
        this.outsideCount = outsideCount;
    }
    public int getAddWorkCount() {
        return addWorkCount;
    }
    public void setAddWorkCount(int addWorkCount) {
        this.addWorkCount = addWorkCount;
    }
    
    
}
