package cn.com.oa.pojo;

public class MeetingLog {

    private String mdate;       // 会议时间
    private String place;       // 会议地点
    private String host;        // 主持人
    private String attendee;    // 出席者
    private String absentee;    // 缺席者
    private String recorder;    // 记录人
    private String topic;       // 会议主题
    private String mconclusion; // 会议总结
    
    public String getMdate() {
        return mdate;
    }
    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getAttendee() {
        return attendee;
    }
    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }
    public String getAbsentee() {
        return absentee;
    }
    public void setAbsentee(String absentee) {
        this.absentee = absentee;
    }
    public String getRecorder() {
        return recorder;
    }
    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getMconclusion() {
        return mconclusion;
    }
    public void setMconclusion(String mconclusion) {
        this.mconclusion = mconclusion;
    }
    
    
}
