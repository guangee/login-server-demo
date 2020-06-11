package com.coding.controller;

import com.coding.common.Const;
import com.coding.domain.User;
import com.coding.mapper.UserMapper;
import com.coding.service.UserService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.guanweiming.common.utils.NumberUtil;
import com.guanweiming.common.utils.Result;
import io.minio.errors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author guanweiming
 */
@Slf4j
@Api(tags = "用户接口")
@AllArgsConstructor
@RequestMapping(Const.API + "user")
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @ApiOperation("登陆接口，返回用户数据")
    @PostMapping("login")
    public Result<User> login(
            @RequestParam String username,
            @RequestParam String password) {
        return userService.login(username, password);
    }


    @ApiOperation("注册用户接口")
    @PostMapping("register")
    public Result<User> register(@RequestParam String username,
                                 @RequestParam String password, String code) {
        return userService.addUser(username, password);
    }


    @ApiOperation("查询所有用户")
    @GetMapping("allUser")
    public Result<List<User>> allUser() {
        return Result.createBySuccess(userMapper.selectAll());
    }


}
