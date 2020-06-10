package cn.com.oa.pojo;

// 申请表
public class ApprovalVo {
    private int appId;
    private String appTitle;     // 申请表标题
    private int sfId;            // 申请人id
    private String sfRealName;   // 申请人姓名
    private String dpmName;      // 申请人所属部门
    private String roleName;     // 申请人所在职位
    private int appTypeId;       // 申请表id
    private String appTypeName;  // 申请表名称
    private String appContent;   // 申请表详情（json字符串）
    private String createDate;   // 创建日期（自动生成） 
    
    private int state;           // 审批状态（0:待审批，  1:审批中，  2:已审批）      
    private String process;      // 审批进程（员工号+姓名：同意——>。。  初始化为null）
    private String approver;     // 审批人id（"id1,id2,id3", 初始化为null）
    private String flag;         // 审批标致（0:未通过，1:通过，   初始化为null）
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
    public String getSfRealName() {
        return sfRealName;
    }
    public void setSfRealName(String sfRealName) {
        this.sfRealName = sfRealName;
    }
    public String getDpmName() {
        return dpmName;
    }
    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public int getAppTypeId() {
        return appTypeId;
    }
    public void setAppTypeId(int appTypeId) {
        this.appTypeId = appTypeId;
    }
    public String getAppTypeName() {
        return appTypeName;
    }
    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName;
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
