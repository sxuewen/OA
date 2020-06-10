package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Notice;
import cn.com.oa.pojo.NoticeVo;

public interface NoticeMapper {

    public int findCountByCondition(String string);

    public int findCount();

    public List<NoticeVo> findAllNotice(int rows, int pageSize);

    public List<NoticeVo> findNoticeByCondition(String notDate, int rows, int pageSize);

    public NoticeVo findNoticeVoById(Integer notId);

    public void updateNotice(Notice notice);

    public void deleteByIds(Integer[] ids);

    public void saveNotice(Notice notice);


}
