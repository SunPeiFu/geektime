package com.sunpeifu.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 作者:  daike
 * 日期:  2020/4/20
 * 描述:
 */
@Aspect
@Component
public class CountAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.sunpeifu.annotation.EnableCount)")
    public void count() {
    }

    @Before(value = "count()")
    public void before(JoinPoint joinPoint) {

        // 获取调用的url
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestUrl = request.getRequestURL().toString();
        // 获取请求ip
        String ip = getRemoteHost(request);
        // 这里无需判断key是否存在,如果存在,则自动进行了 步长+1, 否则为1
        redisTemplate.opsForHash().increment(requestUrl, ip, 1);

    }

    /**
     * 获取目标主机的ip
     *
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}
