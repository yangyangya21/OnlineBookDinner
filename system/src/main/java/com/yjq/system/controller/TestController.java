package com.yjq.system.controller;

import com.yjq.server.domain.Test;
import com.yjq.server.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-22 21:19
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public List<Test> test(){
        return testService.list();
    }
}
