package cn.com.oa.mapper;

import java.util.List;

import cn.com.oa.pojo.Approval;
import cn.com.oa.pojo.ApprovalVo;

public interface ApprovalMapper {

    public int findCountBysfId(int sfId,String param);

    public List<ApprovalVo> findApprovalVoBysfId(int sfId, String string, int rows, int pageSize);

    public void saveApplication(Approval approval);

    public ApprovalVo findApprovalVoByappId(int appId);

    public int findCountByLevelAndResult(String string, String string2);

    public List<ApprovalVo> findAppByLevelAndResult(String string, String string2, int rows,int pageSize);

    public int findCountBydpmIdAndroleLevel(int dpmId, String string);

    public List<ApprovalVo> findAppBydpmIdAndroleLevel(int dpmId, String string, int rows,int pageSize);

    public Approval findAppByappId(Integer appId);

    public void updateApplication(Approval approval);

    public List<ApprovalVo> findAppByApprover(int sfId, String string, int rows, int pageSize);

    public List<ApprovalVo> findAppWithResult(String string, int rows, int pageSize);

    public int findCountWithResult(String string);

    public void deleteApproval(Integer[] ids);

    public int findCountWithApprover(int sfId, String string);     

}
