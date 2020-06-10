package cn.com.oa.pojo;

public class LogVo {

    private int logId;
    private int logType;        // 日志类型（1,日报    2,周报    3,月报    4,会议纪要）
    private String logContent;  // 日志内容（json字符串）
    private String logDate;     // 创建时间  
    private int sfId;           // 用户id
    private String sfUserName;  // 用户名（创建者）
    private int dpmId;          // 所属部门id
    private String dpmName;     // 所属部门名称
    
    public int getLogId() {
        return logId;
    }
    public void setLogId(int logId) {
        this.logId = logId;
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
    public int getSfId() {
        return sfId;
    }
    public void setSfId(int sfId) {
        this.sfId = sfId;
    }
    public String getSfUserName() {
        return sfUserName;
    }
    public void setSfUserName(String sfUserName) {
        this.sfUserName = sfUserName;
    }
    public int getDpmId() {
        return dpmId;
    }
    public void setDpmId(int dpmId) {
        this.dpmId = dpmId;
    }
    public String getDpmName() {
        return dpmName;
    }
    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }
   
    
}
