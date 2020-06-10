package cn.com.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.oa.service.PowerService;

@RequestMapping("power")
@Controller
public class PowerController {

    @Autowired
    private PowerService powerService;
    
    
    
    
}
