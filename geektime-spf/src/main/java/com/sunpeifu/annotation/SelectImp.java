package com.sunpeifu.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 作者:  daike
 * 日期:  2020/4/15
 * 描述:
 */
public class SelectImp implements ImportSelector {
    // 此个方法必须返回的class的全类名
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
            return null;
    }
}
