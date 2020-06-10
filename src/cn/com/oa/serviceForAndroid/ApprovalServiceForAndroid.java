package cn.com.oa.serviceForAndroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.ApprovalMapperForAndroid;
import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalVo;

@Service
public class ApprovalServiceForAndroid {
	@Autowired
    private ApprovalMapperForAndroid approvalMapperForAndroid;
	
	public int addApproval(Approval approval) {
    	return approvalMapperForAndroid.addApproval(approval);
    }
	
	public List<Approval> selectApprovalIsOverTime(int sfId,String createDate){
		return approvalMapperForAndroid.selectApprovalIsOverTime(sfId, createDate);
	}
	public List<ApprovalVo> selectApprovalBySfId(int sfId){
		return approvalMapperForAndroid.selectApprovalBySfId(sfId);
	}
	
	public List<ApprovalVo> selectApprovalHasApprovaled(int preRoleLevel){
		return approvalMapperForAndroid.selectApprovalHasApprovaled(preRoleLevel);
	}
	
	public List<ApprovalVo> selectApprovalWaitForApproval(int preRoleLevel,int preDpmLevel){
		return approvalMapperForAndroid.selectApprovalWaitForApproval(preRoleLevel,preDpmLevel);
	}
	
	public ApprovalVo selectApprovalVoByappId(int appId){
		return approvalMapperForAndroid.selectApprovalVoByappId(appId);
	}
	public int updateApproval(Approval approval){
		return approvalMapperForAndroid.updateApproval(approval);
	}
	
	public Approval selectApprovalByappId(int appId){
		return approvalMapperForAndroid.selectApprovalByappId(appId);
	}

}
