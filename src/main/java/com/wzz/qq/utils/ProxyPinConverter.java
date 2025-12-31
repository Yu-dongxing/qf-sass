package com.wzz.qq.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.wzz.qq.DTO.ProxyPinReportDTO.ProxyPinReportDTO;

import java.util.Map;

public class ProxyPinConverter {

    /**
     * 将 Map 转换为 DTO
     * @param map 接收到的原始 Map
     * @return ProxyPinReportDTO
     */
    public static ProxyPinReportDTO convertMapToDTO(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        // Fastjson2 推荐写法：先转为 JSONObject 再转 JavaObject
        // 这种方式比 JSON.parseObject(JSON.toJSONString(map)) 性能高得多，因为它避免了序列化成字符串的过程
        return JSONObject.from(map).toJavaObject(ProxyPinReportDTO.class);
    }

    /**
     * 如果你拿到的直接是 JSON 字符串，可以使用这个
     */
    public static ProxyPinReportDTO convertStringToDTO(String jsonString) {
        return JSON.parseObject(jsonString, ProxyPinReportDTO.class);
    }
}