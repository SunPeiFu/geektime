package com.sunpeifu.data_structure.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 对账结果表
 * </p>
 *
 * @author
 * @since 2020-03-06
 */
@Data
@Accessors(chain = true)
@Builder
@TableName("pay_verify_amount")
@NoArgsConstructor
@AllArgsConstructor
public class VerifyAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("hpid")
    private String hpid;

    @TableField("hospital_id")
    private String hospitalId;

    @TableField("hospital_name")
    private String hospitalName;

    @TableField("his_order_id")
    private String hisOrderId;

    @TableField("his_order_no")
    private String hisOrderNo;

    @TableField("his_serial_no")
    private String hisSerialNo;

    @TableField("his_refund_no")
    private String hisRefundNo;

    @TableField("merchant_order_id")
    private String merchantOrderId;

    @TableField("merchant_order_no")
    private String merchantOrderNo;

    @TableField("merchant_refund_no")
    private String merchantRefundNo;

    @TableField("trade_amount")
    private BigDecimal tradeAmount;

    @TableField("agency_bill_id")
    private String agencyBillId;

    @TableField("third_transaction_id")
    private String thirdTransactionId;

    @TableField("third_refund_transaction_id")
    private String thirdRefundTransactionId;

    @TableField("different_amount")
    private BigDecimal differentAmount;

    @TableField("verify_status")
    private Integer verifyStatus;

    @TableField("amount_status")
    private Integer amountStatus;

    @TableField("bus_type")
    private Integer busType;

    @TableField("trade_channel")
    private Integer tradeChannel;

    @TableField("pay_type")
    private Integer payType;

    @TableField("trade_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tradeTime;


    @TableField("verify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime verifyTime;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField("verify_mark")
    private String verifyMark;

    @TableField("error_msg")
    private String errorMsg;

    @TableField("error_type")
    private String errorType;

    @TableField("is_deleted")
    private Integer isDeleted;

    /***
     * 根据业务规则,重写hashcode和equals方法
     * 当hisOrderId,agencyBillId,busType一致时认为是同一个对象
     */
    @Override
    public int hashCode() {
        return Objects.hash(hisOrderId, agencyBillId, busType);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifyAmount that = (VerifyAmount) o;
        return Objects.equals(hisOrderId, that.hisOrderId) &&
                Objects.equals(agencyBillId, that.agencyBillId) &&
                Objects.equals(busType, that.busType);
    }

}
