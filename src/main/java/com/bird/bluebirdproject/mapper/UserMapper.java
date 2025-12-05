package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUsernameAndPassword(User user);
}