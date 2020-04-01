package com.sunpeifu.geektime.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 平账表 
 * </p>
 *
 * @author 
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pay_flat_amount")
public class FlatAmount  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;


    @TableField("hospital_id")
    private String hospitalId;

    @TableField("his_order_no")
    private String hisOrderNo;

    @TableField("his_refund_no")
    private String hisRefundNo;


    @TableField("merchant_order_no")
    private String merchantOrderNo;

    @TableField("merchant_refund_no")
    private String merchantRefundNo;

    @TableField("third_transaction_id")
    private String thirdTransactionId;

    @TableField("third_refund_transaction_id")
    private String thirdRefundTransactionId;

    @TableField("flat_status")
    private Integer flatStatus;

    @TableField("before_flat_status")
    private Integer beforeFlatStatus;

    @TableField("flat_time")
    private LocalDateTime flatTime;

    @TableField("flat_mark")
    private String flatMark;

    @TableField("flat_amount")
    private BigDecimal flatAmount;

    @TableField("tradel_amount")
    private BigDecimal tradeAmount;

    @TableField("different_amount")
    private BigDecimal differentAmount;


    @TableField("bus_type")
    private Integer busType;

    @TableField("trade_channel")
    private Integer tradeChannel;

    @TableField("pay_type")
    private Integer payType;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("operate_id")
    private String operateId;

    @TableField("operate_mark")
    private String operateMark;

    @TableField("is_deleted")
    private Integer isDeleted;


}
