package cn.com.oa.mapperForAndroid;

import java.util.List;

import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalVo;

public interface ApprovalMapperForAndroid {
	
	public int addApproval(Approval approval); 
	public List<Approval> selectApprovalIsOverTime(int sfId,String createDate);
	public List<ApprovalVo> selectApprovalBySfId(int sfId);
	public List<ApprovalVo> selectApprovalHasApprovaled(int preRoleLevel);
	public List<ApprovalVo> selectApprovalWaitForApproval(int preRoleLevel,int preDpmLevel);
	public ApprovalVo selectApprovalVoByappId(int appId);
    public int updateApproval(Approval approval);
    public Approval selectApprovalByappId(int appId);

}
