package com.yjq.server.service;

import com.yjq.server.bean.CodeMsg;
import com.yjq.server.dao.UserMapper;
import com.yjq.server.domain.User;
import com.yjq.server.dto.ResponseDto;
import com.yjq.server.dto.UserDto;
import com.yjq.server.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-25 11:00
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public ResponseDto<Boolean> webLogin(UserDto userDto){
        User user = CopyUtil.copy(userDto, User.class);
        if(user == null){
            return ResponseDto.errorByMsg(CodeMsg.DATA_ERROR);
        }

        return ResponseDto.success(true);
    }
}
