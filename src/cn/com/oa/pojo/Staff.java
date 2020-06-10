package cn.com.oa.pojo;

// 员工基本信息表
public class Staff {
    private int sfId;  
    private String sfUserName;  // 用户名（工号）
    private String sfPassword;  // 用户密码
    private String sfRealName;  // 真实姓名
    private String sfSex;       // 性别
    private String sfCard;      // 身份证
    private String sfPhone;     // 手机号
    private String sfAddress;   // 联系地址
    private String sfEmail;     // 电子邮箱
    private Department dpmId;   // 所属部门
    private Role roleId;        // 所属职位
    
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
    public String getSfPassword() {
        return sfPassword;
    }
    public void setSfPassword(String sfPassword) {
        this.sfPassword = sfPassword;
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
    public Department getDpmId() {
        return dpmId;
    }
    public void setDpmId(Department dpmId) {
        this.dpmId = dpmId;
    }
    public Role getRoleId() {
        return roleId;
    }
    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
    
}
