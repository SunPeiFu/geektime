package com.sunpeifu.configuratioon;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/15
 * 描述:
 */
@Component
@ConfigurationProperties(prefix = "myconfiguration")
@Data
public class TestConfiguration {

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
}
