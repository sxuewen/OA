package cn.com.oa.serviceForAndroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.oa.mapperForAndroid.SignMapperForAndroid;
import cn.com.oa.pojo.Sign;

@Service
public class SignServiceForAndroid {
	@Autowired
	private SignMapperForAndroid signMapperForAndroid;
	
	public Sign getSign(){
		return signMapperForAndroid.getSign();
	}
}
