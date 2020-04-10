package com.sunpeifu.data_structure.reflect.annotation;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者:  daike
 * 日期:  2020/4/10
 * 描述:
 */
@Data
@NoArgsConstructor
public class UserMappingVo {

    private String token;

    @MappingCondition
    private String userId;

    @MappingField(mapperClass = UserMapper.class, targetColumnName = "name", targetFieldName="name",targetMappingField = "userId" ,targetMappingFieldValue = "user_id")
    private String userName;
}
