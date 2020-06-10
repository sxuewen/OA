package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalVo;
import cn.com.oa.pojo.Log;
import cn.com.oa.pojo.StaffSign;
import cn.com.oa.serviceForAndroid.ApprovalServiceForAndroid;
import cn.com.oa.serviceForAndroid.LogServiceForAndroid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("approvalInfo")
@Controller
public class ApprovalControllerForAndroid {
	@Autowired
    private ApprovalServiceForAndroid approvalServiceForAndroid;
	
	 	@RequestMapping("/addApproval")
	    @ResponseBody
	    public void addApproval(String approvalStr,HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");
	        System.out.println(approvalStr);
	        JSONObject jo=JSONObject.fromObject(approvalStr);
	        Approval approval=(Approval)JSONObject.toBean(jo, Approval.class);
	        System.out.println(approval.getAppContent());
	        int status=approvalServiceForAndroid.addApproval(approval);
	        System.out.println(status);
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        if(status>0){
//	        	1表示插入成功
	        	jsonObject.element("status", 1);
	        	out.print(jsonObject);
	        }else{
//	        	-1表示插入失败
	        	jsonObject.element("status", -1);
	        	out.print(jsonObject);
	        }    
	    }
	 	
	 	@RequestMapping("/selectApprovalIsOverTime")
	    @ResponseBody
	 	public void selectApprovalIsOverTime(int sfId,String createDate,HttpServletResponse response) throws IOException{
	 		response.setContentType("text/html;charset=utf-8");
	 		List<Approval> approvalList= approvalServiceForAndroid.selectApprovalIsOverTime(sfId, createDate);
	 		PrintWriter out = response.getWriter();
	    	if (approvalList!=null && approvalList.size()>0) {
	    		//转换list数组的
	    		JSONArray depJSONArray = JSONArray.fromObject(approvalList);
				out.print(depJSONArray);
			}else {
				out.print("");
			}
		}
	 	
	 	@RequestMapping("selectApprovalBySfId")
	    @ResponseBody
	 	public void selectApprovalBySfId(int sfId,HttpServletResponse response) throws IOException{
	 		 response.setContentType("textml;charset=utf-8");
	 		 List<ApprovalVo> approvalList= approvalServiceForAndroid.selectApprovalBySfId(sfId);
	 		PrintWriter out = response.getWriter();
	    	if (approvalList!=null && approvalList.size()>0) {
	    		//转换list数组的
	    		JSONArray depJSONArray = JSONArray.fromObject(approvalList);
				out.print(depJSONArray);
			}else {
				out.print("");
			}
		}
	 	
	 	@RequestMapping("selectApprovalHasApprovaled")
	    @ResponseBody
	 	public void selectApprovalHasApprovaled(int preRoleLevel,HttpServletResponse response) throws IOException{
	 		response.setContentType("textml;charset=utf-8");
	 		List<ApprovalVo> approvalList= approvalServiceForAndroid.selectApprovalHasApprovaled(preRoleLevel);
	 		PrintWriter out = response.getWriter();
	    	if (approvalList!=null && approvalList.size()>0) {
	    		//转换list数组的
	    		JSONArray depJSONArray = JSONArray.fromObject(approvalList);
				out.print(depJSONArray);
			}else {
				out.print("");
			}
		}
	 	
	 	@RequestMapping("selectApprovalWaitForApproval")
	    @ResponseBody
	 	public void selectApprovalWaitForApproval(int preRoleLevel,int preDpmLevel,HttpServletResponse response) throws IOException{
	 		response.setContentType("textml;charset=utf-8");
	 		List<ApprovalVo> approvalList= approvalServiceForAndroid.selectApprovalWaitForApproval(preRoleLevel,preDpmLevel);
	 		PrintWriter out = response.getWriter();
	    	if (approvalList!=null && approvalList.size()>0) {
	    		//转换list数组的
	    		JSONArray depJSONArray = JSONArray.fromObject(approvalList);
				out.print(depJSONArray);
			}else {
				out.print("");
			}
		}
	 	@RequestMapping("selectApprovalVoByappId")
	    @ResponseBody
	 	public void selectApprovalVoByappId(HttpServletResponse response,int appId) throws IOException{
	 		response.setContentType("textml;charset=utf-8");
	 		PrintWriter out = response.getWriter();
	 		ApprovalVo approvalVo = approvalServiceForAndroid.selectApprovalVoByappId(appId);
	 		if (approvalVo != null) {
				JSONObject jsonObject = JSONObject.fromObject(approvalVo);
				out.println(jsonObject);
			}else {
				out.println("");
			}
	 		
	 	}
	 	@RequestMapping("/updateApproval")
	    @ResponseBody
	 	public void updateApproval(String approvalStr,HttpServletResponse response) throws IOException{
			response.setContentType("textml;charset=utf-8");
	        System.out.println(approvalStr);
	        JSONObject jo=JSONObject.fromObject(approvalStr);
	        Approval approval=(Approval)JSONObject.toBean(jo, Approval.class);
	        int status=approvalServiceForAndroid.updateApproval(approval);
	        JSONObject jsonObject=new JSONObject();
	        PrintWriter out = response.getWriter();
	        if(status>0){
//	        	1表示插入成功
	        	jsonObject.element("status", 1);
	        	out.print(jsonObject);
	        }else{
//	        	-1表示插入失败
	        	jsonObject.element("status", -1);
	        	out.print(jsonObject);
	        }    
		}
	 	
	 	@RequestMapping("selectApprovalByappId")
	    @ResponseBody
	 	public void selectApprovalByappId(HttpServletResponse response,int appId) throws IOException{
	 		response.setContentType("textml;charset=utf-8");
	 		PrintWriter out = response.getWriter();
	 		Approval approval = approvalServiceForAndroid.selectApprovalByappId(appId);
	 		if (approval != null) {
				JSONObject jsonObject = JSONObject.fromObject(approval);
				out.println(jsonObject);
			}else {
				out.println("");
			}
	 		
	 	}


}
