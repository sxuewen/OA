package cn.com.oa.controllerForAndroid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.oa.pojo.Sign;
import cn.com.oa.serviceForAndroid.SignServiceForAndroid;
import net.sf.json.JSONObject;

@RequestMapping("signInfo")
@Controller
public class SignControllerForAndroid {
	@Autowired
	private SignServiceForAndroid signServiceForAndroid;
	
	@RequestMapping(value="/getSign")
    @ResponseBody
    public void getSign(HttpServletResponse response) throws IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	System.out.println("MMMM");
        Sign sign=signServiceForAndroid.getSign();
        if (sign==null) {
            out.print("");
        }else {
            JSONObject jsonObject = JSONObject.fromObject(sign);
        	out.print(jsonObject);
        }
    }

}
