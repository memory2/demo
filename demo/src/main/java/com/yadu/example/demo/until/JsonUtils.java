package com.yadu.example.demo.until;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * Json工具类
 * @author
 */
public class JsonUtils {

    /**
     * java对象转成json字符串
     * @param obj 源对象
     * @return JSON字符串
     */
    public static String objToJson(Object obj) {
        if (obj != null) {
            return JSONObject.toJSONString(obj);
        }
        return null;
    }

    /**
     * json字符串转成java对象
     * @param json JSON字符串
     * @param clazz 转成的目标对象类型
     * @param <T> 目标对象
     * @return
     */
    public static <T> T jsonToObj(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     * @param jsonData JSON数据
     * @param clazz 指定的java对象
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成较为复杂的List<Map<String, Object>>
     * @param jsonData JSON数据
     * @return List<Map<String, Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }
}

