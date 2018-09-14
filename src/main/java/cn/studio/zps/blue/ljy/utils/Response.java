package cn.studio.zps.blue.ljy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public class Response {
    /**
     * 获取一定返回格式的结果集
     * @param code 表示结果集状态，规定成功为0，失败为1
     * @param msg 表示结果集的信息，规定成功时为"***成功"，规定失败为"***失败"
     * @param data 表示结果集返回的数据
     * @return 结果集
     */
    public static Map<String,Object> getResponseMap(int code,String msg,Object data) {
        Map<String,Object> responseMap=new HashMap<>(3);
        responseMap.put("code",code);
        responseMap.put("msg",msg);
        responseMap.put("data",data);
        return responseMap;
    }
}
