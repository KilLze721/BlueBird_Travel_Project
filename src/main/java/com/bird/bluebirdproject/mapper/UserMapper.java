package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户信息
     * @param user 用户对象，包含用户名和密码
     * @return 用户信息，包含用户ID、用户名、密码等
     */
    User getUsernameAndPassword(User user);
}