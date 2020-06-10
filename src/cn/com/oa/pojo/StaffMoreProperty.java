package cn.com.oa.pojo;

public class StaffMoreProperty {

    /**
     * dpmName :
     * roleName :
     * sfAddress : 河北省邯郸市
     * sfCard : 132412419647656931
     * sfEmail : xiaoyuan@21.com
     * sfId : 0
     * sfPhone : 15615135133
     * sfRealName : 小源
     * sfSex : 男
     * sfUserName : admin
     */

    private String dpmName;
    private String roleName;
    private String sfAddress;
    private String sfCard;
    private String sfEmail;
    private int sfId;
    private int dpmId;
    private int roleId;
    private int parentId;
	private String sfPhone;
    private String sfRealName;
    private String sfSex;
    private String sfUserName;
    private String sfPassword;
    private String dpmDescription;
    private String dpmCreatDate;
    private int dpmLevel;
    private String roleDescription;
    private int roleLevel;

    public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

    public String getSfAddress() {
        return sfAddress;
    }

    public void setSfAddress(String sfAddress) {
        this.sfAddress = sfAddress;
    }

    public String getSfCard() {
        return sfCard;
    }

    public void setSfCard(String sfCard) {
        this.sfCard = sfCard;
    }

    public String getSfEmail() {
        return sfEmail;
    }

    public void setSfEmail(String sfEmail) {
        this.sfEmail = sfEmail;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getSfPhone() {
        return sfPhone;
    }

    public void setSfPhone(String sfPhone) {
        this.sfPhone = sfPhone;
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

    public String getDpmDescription() {
        return dpmDescription;
    }

    public void setDpmDescription(String dpmDescription) {
        this.dpmDescription = dpmDescription;
    }

    public String getDpmCreatDate() {
        return dpmCreatDate;
    }

    public void setDpmCreatDate(String dpmCreatDate) {
        this.dpmCreatDate = dpmCreatDate;
    }

    public int getDpmLevel() {
        return dpmLevel;
    }

    public void setDpmLevel(int dpmLevel) {
        this.dpmLevel = dpmLevel;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }
}
