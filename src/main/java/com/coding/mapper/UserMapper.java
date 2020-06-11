package com.coding.mapper;

import com.coding.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author guanweiming
 */
@Repository
public interface UserMapper extends Mapper<User>, SelectByIdListMapper<User,Long> {
}
