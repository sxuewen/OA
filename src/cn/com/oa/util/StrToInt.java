package cn.com.oa.util;

import org.apache.commons.lang.StringUtils;

public class StrToInt {
    /**
     * 该方法完成的功能是转化字符串类型的数组为整形数组
     * 
     * @param sids
     * @return
     */
    public static Integer[] converterStringArray2IntegerArray(String[] sids) {
        if (sids != null && sids.length > 0) {
            Integer[] ids = new Integer[sids.length];
            for (int i = 0; i < sids.length; i++) {
                if (StringUtils.isNotBlank(sids[i])) {
                    ids[i] = Integer.parseInt(sids[i]);
                }
            }
            return ids;
        }
        return null;
    }

}
