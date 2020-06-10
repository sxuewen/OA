package cn.com.oa.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.oa.pojo.Department;
import cn.com.oa.pojo.Models;
import cn.com.oa.pojo.Power;
import cn.com.oa.pojo.Role;
import cn.com.oa.pojo.Staff;
import cn.com.oa.service.ModelsService;
import cn.com.oa.service.PowerService;

@RequestMapping
@Controller
public class PageController {

    @Autowired
    private PowerService powerService;
    
    @Autowired
    private ModelsService modelService;
    
    /*@RequestMapping(value="/left")
    public String left(HttpServletRequest request, Model model) {
        List<Models> modelsList;
        List<Models> modelsList2; // 保存子模块
        Map<String, List<Models>> map = new HashMap<String, List<Models>>();
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("staff");
        Department dpm = staff.getDpmId();
        Role role = staff.getRoleId();
        Power power = powerService.findPowerByCondition(dpm.getDpmLevel(), role.getRoleLevel());
        String str = power.getModelId(); // 获取模块Id

        if (str.length() == 1) { // 只有一个父模块
            modelsList = modelService.findModelById(Integer.parseInt(str));
        } else {
            String[] ids = str.split(",");
            modelsList = modelService.findModelByIds(ids); // 根据Id查询所有的模块
            for (int i = 0; i < modelsList.size(); i++) {
                Models model2 = modelsList.get(i);
                if (model2.getParentId() == null) { // 父模块
                    modelsList2 = modelService.findModelByParentId(String.valueOf(model2.getModelId()));
                    map.put(model2.getModelName(), modelsList2);
                }
            }
        }
        model.addAttribute("map", map);
        return "menu/left";
    }*/
    
    
    
    @RequestMapping(value="/left")
    public String left(HttpServletRequest request, Model model) {
        List<Models> modelsList;
//      List<Models> modelsList2 = new LinkedList<Models>(); 
        Map<String, List<Models>> map = new HashMap<String, List<Models>>();
        // 获取模块id
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("staff");
        Department dpm = staff.getDpmId();
        Role role = staff.getRoleId();
        Power power = powerService.findPowerByCondition(dpm.getDpmLevel(), role.getRoleLevel());        
        String str = power.getModelId(); 
        
        String[] ids = str.split(",");
        modelsList = modelService.findModelByIds(ids);
        for(Models models : modelsList){
            if (models.getParentId()==null) {
                List<Models> list=new LinkedList<Models>();
                map.put(models.getModelName(), list);
            }else {               
                Models parentModel=modelService.findParentModelByParentId(Integer.valueOf(models.getParentId()));
                if (map.get(parentModel.getModelName())!=null) {
                    map.get(parentModel.getModelName()).add(models); 
                }                                               
            }
        }        
        model.addAttribute("map", map);
        return "menu/left";
    }
    
    
    
    
    @RequestMapping(value="/top")
    public String top(){
        return "menu/top";
    }
    @RequestMapping(value="/welcome")
    public String welcome(){
        return "menu/welcome";
    }
}
