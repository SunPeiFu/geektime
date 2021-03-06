package com.sunpeifu.data_structure.reflect.annotation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表  Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2020-04-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
