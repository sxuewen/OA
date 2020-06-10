package cn.com.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.oa.service.ApprovalTypeService;

@RequestMapping("approvalType")
@Controller
public class ApprovalTypeController {

    @Autowired
    private ApprovalTypeService appTypeService;
    
    
}
