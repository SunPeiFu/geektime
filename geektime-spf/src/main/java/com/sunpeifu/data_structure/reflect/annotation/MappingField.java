package com.sunpeifu.data_structure.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MappingField {

    Class<?> mapperClass();

    String targetMappingField();

    String targetMappingFieldValue() default "id";

    String targetColumnName();

    String targetFieldName();

    String method() default "selectById";

    //

}
