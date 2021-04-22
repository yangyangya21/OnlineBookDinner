package com.yjq.programmer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-22 21:19
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
