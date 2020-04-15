package com.sunpeifu.resttemplate;

import com.sunpeifu.resttemplate.entity.InsReqInBaseBean;
import com.sunpeifu.resttemplate.entity.Result;
import com.sunpeifu.resttemplate.entity.TemplateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作者:  daike
 * 日期:  2020/4/14
 * 描述:
 */
@RestController
public class RestTemplateController {

    @PostMapping("testTemplateReceive")
    public Result<TemplateDto> test(@RequestBody TemplateDto dto){
        if (null != dto){
           dto.setIsAck(true);
           dto.setMsg("接收方收到");
            List<InsReqInBaseBean> baseBeanList = dto.getBaseBeanList();
            baseBeanList.forEach(e->{
                e.setAction("接收方list接收");
                e.setDirectPay(true);
            });
        }
        return Result.wrapSuccessfulResult(dto);
    }
}
