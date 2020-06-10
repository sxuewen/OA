package cn.com.oa.util;

import java.lang.reflect.Field;

public class JudgeNotNull {

    // 判断一个对象的属性是否全不为空并且全不为""（全不为空并且不为""，返回true; 否则，返回false）
    @SuppressWarnings("rawtypes")
    public static boolean isFieldsNotNull(Object obj) throws Exception{
        boolean flag=true;
        Class clazz=obj.getClass();         // 得到类对象
        Field[] fields=clazz.getDeclaredFields();  // 得到类对象的属性集合
        for(Field field : fields){          // 遍历属性集合
            field.setAccessible(true);      // 设置属性可以访问（private也可以访问，不设置则无法访问private属性）
            Object value=field.get(obj);    // 得到该属性的值
            if (value==null||value=="") {              // 如果有属性为空或""，就返回false
                flag=false;
                break;
            }
        }
        return flag;
    }
}
