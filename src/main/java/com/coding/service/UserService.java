package com.coding.service;

import com.coding.domain.User;
import com.coding.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.guanweiming.common.utils.HttpKit;
import com.guanweiming.common.utils.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author guanweiming
 */
@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;


    public Result<User> login(String username, String password) {
        User user = getUserByUsernameAndPassword(username, password);
        if (user == null) {
            return Result.createByErrorMessage("登陆失败");
        }
        HttpKit.getRequest().getSession().setAttribute("user", user);
        return Result.createBySuccess(user);
    }


    private User getUserByUsernameAndPassword(String username, String password) {
        User record = new User();
        record.setUsername(username);
        record.setPassword(password);
        PageHelper.startPage(1, 1);
        List<User> list = userMapper.select(record);
        return list.size() == 0 ? null : list.get(0);
    }


    public Result<User> addUser(String username, String password) {
        User record = new User();
        record.setUsername(username);
        List<User> list = userMapper.select(record);
        if (!CollectionUtils.isEmpty(list)) {
            return Result.createByErrorMessage("用户已经存在，无法添加");
        }
        record.setPassword(password);
        int resultCount = userMapper.insertSelective(record);
        return resultCount == 0 ? Result.createByErrorMessage("添加失败") : Result.createBySuccess(record);
    }


}
