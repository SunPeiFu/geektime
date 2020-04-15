package com.sunpeifu.resttemplate.entity;

import lombok.Data;

import java.util.List;

/**
 * 作者:  daike
 * 日期:  2020/4/14
 * 描述:
 */
@Data
public class TemplateDto {


    private Boolean isAck;

    private String msg;

    private List<InsReqInBaseBean> baseBeanList;

}
