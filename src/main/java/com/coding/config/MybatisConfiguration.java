package com.coding.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author guanweiming
 */
@MapperScan("com.coding.mapper")
@Configuration
public class MybatisConfiguration {
}
