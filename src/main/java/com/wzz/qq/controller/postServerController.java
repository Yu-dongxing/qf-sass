package com.wzz.qq.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSON;
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
    public Result<?> cs(@RequestBody Map<String, Object> map) {
        log.info("参数传入：{}", JSON.toJSONString(map));
        return Result.success();
    }
}
