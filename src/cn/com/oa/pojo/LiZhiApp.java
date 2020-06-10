package cn.com.oa.pojo;

public class LiZhiApp {
  
    private String LZType;        // 离职类型（辞职、辞退、除名、合同到期、其他）
    private String LZDate;        // 打算离职日期（年月日）
    private String LZReason;      // 离职原因
    
    public String getLZType() {
        return LZType;
    }
    public void setLZType(String lZType) {
        LZType = lZType;
    }
    public String getLZDate() {
        return LZDate;
    }
    public void setLZDate(String lZDate) {
        LZDate = lZDate;
    }
    public String getLZReason() {
        return LZReason;
    }
    public void setLZReason(String lZReason) {
        LZReason = lZReason;
    }
    
    
}
