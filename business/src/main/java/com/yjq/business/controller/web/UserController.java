package com.yjq.business.controller.web;

import com.yjq.server.dto.ResponseDto;
import com.yjq.server.dto.UserDto;
import com.yjq.server.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-25 10:58
 */
/**
 * 前台用户控制器
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 前台用户登录操作处理
     * @param userDto
     * @return
     */
    @PostMapping("/login")
    public ResponseDto<UserDto> login(@RequestBody UserDto userDto){
        return userService.webLogin(userDto);
    }

    /**
     * 检查用户是否登录
     * @param userDto
     * @return
     */
    @PostMapping("/check_login")
    public ResponseDto<UserDto> checkLogin(@RequestBody UserDto userDto){
        return userService.checkLogin(userDto);
    }

}
