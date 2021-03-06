package com.yjq.server.service;

import com.alibaba.fastjson.JSON;
import com.yjq.server.bean.CodeMsg;
import com.yjq.server.dao.UserMapper;
import com.yjq.server.domain.User;
import com.yjq.server.domain.UserExample;
import com.yjq.server.dto.ResponseDto;
import com.yjq.server.dto.UserDto;
import com.yjq.server.util.CommonUtil;
import com.yjq.server.util.CopyUtil;
import com.yjq.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-25 11:00
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 前台用户登录操作处理
     * @param userDto
     * @return
     */
    public ResponseDto<UserDto> webLogin(UserDto userDto){
        User user = CopyUtil.copy(userDto, User.class);
        if(user == null){
            return ResponseDto.errorByMsg(CodeMsg.DATA_ERROR);
        }
        //根据用户名昵称和密码查询
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        if(userList == null || userList.size() == 0){
            return ResponseDto.errorByMsg(CodeMsg.USERNAME_OR_PASSWD_ERROR);
        }
        UserDto selectedUserDto = CopyUtil.copy(userList.get(0), UserDto.class);
        String token = UuidUtil.getShortUuid();
        selectedUserDto.setToken(token);
        //把token存入redis中 有效期1小时
        stringRedisTemplate.opsForValue().set(token, JSON.toJSONString(selectedUserDto), 3600, TimeUnit.SECONDS);
        return ResponseDto.success(selectedUserDto);
    }

    /**
     * 检查用户是否登录
     * @param userDto
     * @return
     */
    public ResponseDto<UserDto> checkLogin(UserDto userDto){
        if(userDto == null || CommonUtil.isEmpty(userDto.getToken())){
            return ResponseDto.errorByMsg(CodeMsg.USER_SESSION_EXPIRED);
        }
        String value = stringRedisTemplate.opsForValue().get(userDto.getToken());
        if(CommonUtil.isEmpty(value)){
            return ResponseDto.errorByMsg(CodeMsg.USER_SESSION_EXPIRED);
        }
        UserDto selectedUserDto = JSON.parseObject(value, UserDto.class);
        logger.info("获取到的登录信息={}", selectedUserDto);
        return ResponseDto.success(selectedUserDto);
    }

}
