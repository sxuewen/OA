package cn.com.oa.pojo;

public class NoticeVo extends Notice{

    private int yesNum;   // 已读人数
    private int noNum;    // 未读人数
    private int flag;     // 阅读标志
    
    public int getYesNum() {
        return yesNum;
    }
    public void setYesNum(int yesNum) {
        this.yesNum = yesNum;
    }
    public int getNoNum() {
        return noNum;
    }
    public void setNoNum(int noNum) {
        this.noNum = noNum;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
   
}
