package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.NoticeVo;
import cn.com.oa.service.NoticeService;
import cn.com.oa.service.StaffService;
import cn.com.oa.serviceForAndroid.NoticeServiceForAndroid;
import cn.com.oa.serviceForAndroid.StaffNoticeServiceForAndroid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("noticeInfo")
@Controller
public class NoticeControllerForAndroid {
	@Autowired
	private NoticeServiceForAndroid noticeServiceForAndroid;
	@Autowired
	private StaffNoticeServiceForAndroid staffNoticeServiceForAndroid;
	@Autowired
    private NoticeService noticeService;
    @Autowired
    private StaffService staffService;

	//查询所有公告
    @RequestMapping("/findAllNotice")
    @ResponseBody
    public void findAllNotice(HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	List<NoticeVo> noticeList = noticeServiceForAndroid.findAllNoticeForAndroid();
    	PrintWriter out = response.getWriter();
    	if (noticeList!=null && noticeList.size()>0) {
    		//转换list数组的
    		JSONArray androidnoticeList = JSONArray.fromObject(noticeList);
			out.print(androidnoticeList);
		}else {
			out.print("");
		}
    }
    
  //根据noticeId 查询公告
    @RequestMapping("selectNoticeByNoticeId")
    @ResponseBody
    public void selectNoticeByNoticeId(HttpServletResponse response,int noticeId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	NoticeVo noticeVo  = noticeService.findNoticeVoById(noticeId);
    	PrintWriter out = response.getWriter();
        int number=staffService.findCount();
    	if (noticeVo!=null) {
    		noticeVo.setNoNum(number-noticeVo.getYesNum());
    		JSONObject jsonObject = JSONObject.fromObject(noticeVo);
			out.print(jsonObject);
		}else {
			out.print("");
		}
    }

    
  //已读
    @RequestMapping("/yesRead")
    @ResponseBody
    public void yesRead(HttpServletResponse response,int notId,int sfId) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	int result = staffNoticeServiceForAndroid.yesReadForAndroid(notId, sfId);
    	JSONObject jsonObject = new JSONObject();
    	if (result>0) {
    		jsonObject.element("status", 1);
    		out.print(jsonObject);
		}else {
			jsonObject.element("status", -1);
			out.print(jsonObject);
		}
    }
    //点击某一个公告时查看员工是否已读
    @RequestMapping("selectIsYesRead")
    @ResponseBody
    public void selectIsYesRead(HttpServletResponse response,int notId,int sfId)throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	NoticeVo noticeVo = staffNoticeServiceForAndroid.selectIsYesRead(notId, sfId);
    	if (noticeVo!=null) {
    		JSONObject jsonObject = JSONObject.fromObject(noticeVo);
			out.print(jsonObject);
		}else {
			out.print("");
		}
    }


}
