package com.sunpeifu.resttemplate.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 保险公司请求基础入參
 *
 * @author Zengzhong
 * @date 2019-08-16
 */
@Data
public class InsReqInBaseBean {

    /**
     * 保险机构Id
     */
    @NotNull(message = "保险平台icpid不能为空")
    private String icpid;

    /**
     * 保险公司Id
     */
    private String cid;

    /**
     * 业务Id
     */
    private String tbid;

    /**
     * 请求Url的Action名字
     */
    private String action;

    /**
     * 发起渠道
     */
    private int channelName;

    /**
     * 大字符串
     */
    private String req;

    /**
     * 功能描述: 是否是直赔
     *
     * @date 2019/8/22 4:44 下午
     * @author zengzhong
     */
    private Boolean directPay;

//    /**
//     * c端保险公司接口类型参数
//     */
//    private InsApiEnum apiType;
}