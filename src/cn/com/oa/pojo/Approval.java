package cn.com.oa.pojo;

// 申请表
public class Approval {
    private int appId;
    private String appTitle;     // 申请表标题
    private int sfId;            // 申请人id
    private int dpmId;           // 待处理部门id（普通部门经理审批标志）    
    private int appTypeId;       // 申请表类型
    
    private int dayFlag;         // 直接决定标志（ 0，可以直接给出结果；  1，需要往上传递）
    private String preRoleLevel; // 待处理职位的等级（没有则为null）
    private String preDpmLevel;  // 待处理部门的等级（人力部经理审批标志）
    private String appContent;   // 申请表详情（json字符串）    
    private String createDate;   // 创建日期（自动生成）  
    private int state;           // 审批状态（0:待审批，  1:审批中，  2:已审批）      
    private int haveTime;        // 时间限制标志（0，没有；  1，小时；  2，天数）
    
    private String process;      // 审批进程（员工号+姓名：同意——>。。  初始化为null）
    private String approver;     // 审批人id（"id1,id2,id3", 初始化为null）
    private String flag;         // 审批标志（0:未通过，1:通过，   初始化为null）
    private String result;       // 最终审批结果（0:未通过；1:已通过，  初始化为null）
    private String resultDate;   // 最终审批时间（出结果时自动创建）
    private String refuseReason; // 不通过原因（当审批标致为0时显示）
    
    public int getAppId() {
        return appId;
    }
    public void setAppId(int appId) {
        this.appId = appId;
    }
    public String getAppTitle() {
        return appTitle;
    }
    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
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
    public int getAppTypeId() {
        return appTypeId;
    }
    public void setAppTypeId(int appTypeId) {
        this.appTypeId = appTypeId;
    }
    public int getDayFlag() {
        return dayFlag;
    }
    public void setDayFlag(int dayFlag) {
        this.dayFlag = dayFlag;
    }
    public String getPreRoleLevel() {
        return preRoleLevel;
    }
    public void setPreRoleLevel(String preRoleLevel) {
        this.preRoleLevel = preRoleLevel;
    }
    public String getPreDpmLevel() {
        return preDpmLevel;
    }
    public void setPreDpmLevel(String preDpmLevel) {
        this.preDpmLevel = preDpmLevel;
    }
    public String getAppContent() {
        return appContent;
    }
    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getProcess() {
        return process;
    }
    public void setProcess(String process) {
        this.process = process;
    }
    public String getApprover() {
        return approver;
    }
    public void setApprover(String approver) {
        this.approver = approver;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public int getHaveTime() {
        return haveTime;
    }
    public void setHaveTime(int haveTime) {
        this.haveTime = haveTime;
    }
    public String getResultDate() {
        return resultDate;
    }
    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }
    public String getRefuseReason() {
        return refuseReason;
    }
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }
    
}
