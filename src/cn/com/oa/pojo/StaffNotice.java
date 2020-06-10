package cn.com.oa.pojo;

public class StaffNotice {

    private int id;
    private int notId; // 公告Id
    private int sfId;  // 员工Id
    private int state; // 员工的的阅读状态（1，已读）
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNotId() {
        return notId;
    }
    public void setNotId(int notId) {
        this.notId = notId;
    }
    public int getSfId() {
        return sfId;
    }
    public void setSfId(int sfId) {
        this.sfId = sfId;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
}
