package cn.com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapper.ApprovalMapper;
import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalVo;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalMapper approvalMapper;
    
    
    public int findCountBysfId(int sfId,String param) {
        return approvalMapper.findCountBysfId(sfId,param);
    }

    public List<ApprovalVo> findApprovalVoBysfId(int sfId, String string, int rows, int pageSize) {
        List<ApprovalVo> approvalVoList=approvalMapper.findApprovalVoBysfId(sfId,string,rows,pageSize);
        return approvalVoList;
    }

    public void saveApplication(Approval approval) {
        approvalMapper.saveApplication(approval);
    }

    public ApprovalVo findApprovalVoByappId(int appId) {
        return approvalMapper.findApprovalVoByappId(appId);
    }

    public int findCountByLevelAndResult(String string, String string2) {
        return approvalMapper.findCountByLevelAndResult(string,string2);
    }

    public List<ApprovalVo> findAppByLevelAndResult(String string, String string2,int rows,int pageSize) {
        List<ApprovalVo> approvalList=approvalMapper.findAppByLevelAndResult(string,string2,rows,pageSize);
        return approvalList;
    }

    public int findCountBydpmIdAndroleLevel(int dpmId, String string) {
        return approvalMapper.findCountBydpmIdAndroleLevel(dpmId,string);
    }

    public List<ApprovalVo> findAppBydpmIdAndroleLevel(int dpmId, String string,int rows,int pageSize) {
        List<ApprovalVo> approvalList=approvalMapper.findAppBydpmIdAndroleLevel(dpmId,string,rows,pageSize);
        return approvalList;
    }

    public Approval findAppByappId(Integer appId) {
        return approvalMapper.findAppByappId(appId);
    }

    public void updateApplication(Approval approval) {
        approvalMapper.updateApplication(approval);
    }
   
    public int findCountWithResult(String string) {
        return approvalMapper.findCountWithResult(string);
    }
    
    public List<ApprovalVo> findAppWithResult(String string, int rows, int pageSize) {
        List<ApprovalVo> approvalVoList=approvalMapper.findAppWithResult(string,rows,pageSize);
        return approvalVoList;
    }

    public void deleteApproval(Integer[] ids) {
        approvalMapper.deleteApproval(ids);
    }

    public int findCountWithApprover(int sfId, String string) {
        return approvalMapper.findCountWithApprover(sfId,string);
    }

    public List<ApprovalVo> findAppByApprover(int sfId, String string, int rows, int pageSize) {
        List<ApprovalVo> approvalVoList=approvalMapper.findAppByApprover(sfId,string,rows,pageSize);
        return approvalVoList;
    }  
    
    
    

}
