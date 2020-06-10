package cn.com.oa.pojo;

public class StaffInfo {

    private int sfId;  // 主键
    private String sfUserName;  // 用户名
    private String sfRealName;  // 真实姓名
    private String sfSex;  // 性别
    private String sfCard;  // 身份证
    private String sfPhone;  // 手机号
    private String sfAddress;  // 联系地址
    private String sfEmail;  // 电子邮箱 
    private String dpmName;  // 部门名称
    private String roleName; // 职位名称
    
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
    public String getSfRealName() {
        return sfRealName;
    }
    public void setSfRealName(String sfRealName) {
        this.sfRealName = sfRealName;
    }
    public String getSfSex() {
        return sfSex;
    }
    public void setSfSex(String sfSex) {
        this.sfSex = sfSex;
    }
    public String getSfCard() {
        return sfCard;
    }
    public void setSfCard(String sfCard) {
        this.sfCard = sfCard;
    }
    public String getSfPhone() {
        return sfPhone;
    }
    public void setSfPhone(String sfPhone) {
        this.sfPhone = sfPhone;
    }
    public String getSfAddress() {
        return sfAddress;
    }
    public void setSfAddress(String sfAddress) {
        this.sfAddress = sfAddress;
    }
    public String getSfEmail() {
        return sfEmail;
    }
    public void setSfEmail(String sfEmail) {
        this.sfEmail = sfEmail;
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
    
    
}
