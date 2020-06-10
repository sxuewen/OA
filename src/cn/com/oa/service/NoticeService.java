package cn.com.oa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.oa.mapper.NoticeMapper;
import cn.com.oa.pojo.Notice;
import cn.com.oa.pojo.NoticeVo;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public int findCountByCondition(String string) {        
        return noticeMapper.findCountByCondition(string);
    }

    public int findCount() {
        return noticeMapper.findCount();
    }

    public List<NoticeVo> findAllNotice(int rows, int pageSize) {
        List<NoticeVo> noticeList=noticeMapper.findAllNotice(rows,pageSize);
        return noticeList;
    }

    public List<NoticeVo> findNoticeByCondition(String notDate, int rows, int pageSize) {
        List<NoticeVo> noticeList=noticeMapper.findNoticeByCondition(notDate,rows,pageSize);
        return noticeList;
    }

    public NoticeVo findNoticeVoById(Integer notId) {
        return noticeMapper.findNoticeVoById(notId);
    }

    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    public void deleteByIds(Integer[] ids) {
        noticeMapper.deleteByIds(ids);
    }

    public void saveNotice(Notice notice) {
        noticeMapper.saveNotice(notice);
    }

}
