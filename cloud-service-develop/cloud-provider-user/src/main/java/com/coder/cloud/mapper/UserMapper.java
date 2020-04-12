package com.coder.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.api.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 13:38
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
