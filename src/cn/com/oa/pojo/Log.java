package cn.com.oa.pojo;
/**
 * 会议纪要：时间，地点，主持人，出席者，缺席者，记录人，会议主题，会议总结
 * 日报：姓名，部门，时间，今日工作总结，存在的问题，解决方法，明天工作计划
 * 周报：姓名，部门，时间，本周工作总结，存在的问题，解决方法，下周工作计划
 * 月报：姓名，部门，时间，本月工作总结，存在的问题，解决方法，下月工作计划
 * @author yuan
 *
 */
//  日志表
public class Log {
    private int logId;    
    private int sfId;           // 用户id
    private int dpmId;          // 部门id
    private int logType;        // 日志类型（1,日报    2,周报    3,月报    4,会议纪要）
    private String logContent;  // 日志内容（json字符串）
    private String logDate;     // 创建时间    
    
    public int getLogId() {
        return logId;
    }
    public void setLogId(int logId) {
        this.logId = logId;
    }
    public int getSfId() {
        return sfId;
    }
    public void setSfId(int sfId) {
        this.sfId = sfId;
    }
    public int getDpmId() {
        return dpmId;
    }
    public void setDpmId(int dpmId) {
        this.dpmId = dpmId;
    }
    public int getLogType() {
        return logType;
    }
    public void setLogType(int logType) {
        this.logType = logType;
    }
    public String getLogContent() {
        return logContent;
    }
    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
    public String getLogDate() {
        return logDate;
    }
    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }
   
}
