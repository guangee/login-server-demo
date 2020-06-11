package com.coding.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chezhu.xin
 */
@Slf4j
@ControllerAdvice
@RestController
public class RestExceptionController {

    /**
     * 客户端没有登录，让他去登录
     */
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.OK)
    public void unauthenticatedException(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUrl = request.getContextPath() + "/login";
        log.debug("客户端没有登录访问，让他去登录:" + loginUrl);
        response.sendRedirect(loginUrl);
    }
}
