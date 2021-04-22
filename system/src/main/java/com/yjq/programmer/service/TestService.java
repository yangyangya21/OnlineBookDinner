package com.yjq.programmer.service;

import com.yjq.programmer.dao.TestDao;
import com.yjq.programmer.domain.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-22 22:33
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;

    public List<Test> list(){
        return testDao.list();
    }

}
