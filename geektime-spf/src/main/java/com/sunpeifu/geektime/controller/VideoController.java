package com.sunpeifu.geektime.controller;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 作者:  sunpeifu
 * 日期:  2020/4/6
 * 描述:
 */
@RestController
public class VideoController {


    @RequestMapping("video")
    public Object video(@RequestParam("file")MultipartFile file){
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        // 获取原文件名
        String originalFilename = file.getOriginalFilename();
        // 图片存储的路径
        String urlPath = "images"+ File.separator+originalFilename;
        // 图片保存的路径
        String savePath = staticPath + File.separator + urlPath;
        File saveFile = new File(savePath);
        String visitPath = "static/"+urlPath;
        // 判断文件夹是否存在
        boolean exists = saveFile.exists();
        if (!exists) {
            saveFile.mkdirs();
        }
        // 存到项目路径下
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitPath;

    }
}
