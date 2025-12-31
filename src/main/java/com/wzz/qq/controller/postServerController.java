package com.wzz.qq.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSON;
import com.wzz.qq.DTO.ProxyPinReportDTO.ProxyPinReportDTO;
import com.wzz.qq.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/cs")
public class postServerController {
    @PostMapping("")
    public Result<?> cs(@RequestBody ProxyPinReportDTO mmm) {
        // 1. 安全校验：确保 request 和 postData 不为空
        if (mmm.getRequest() == null) {
            return Result.success(); // 或者返回错误
        }

        String url = mmm.getRequest().getUrl();
        ProxyPinReportDTO.PostDataDTO postData = mmm.getRequest().getPostData();

        // 2. 定义目标 URL
        String targetUrl = "https://jediassist4.qiaofangyun.com/api/jedipropertyentrust/distribution/list";

        // 3. 执行过滤逻辑
        // 判断 URL 是否匹配（考虑到可能带参数，用 startsWith 或 equals）
        if (url != null && url.startsWith(targetUrl)) {
            log.info("【捕获目标请求】URL: {},请求参数：{}", url,mmm);
            // 判断请求体中是否包含 employeeUuid
            if (postData != null && postData.getText() != null) {
                String requestBody = postData.getText();


                // 使用包含判断或正则判断
                if (requestBody.contains("employeeUuid")) {

                    // 命中目标，执行你的逻辑

                    log.info("请求数据: {}", requestBody);
                    log.info("返回数据: {}", mmm.getResponse().getContent());

                    // TODO: 在这里处理你的业务逻辑
                }
            }
        }

        return Result.success();
    }
}
