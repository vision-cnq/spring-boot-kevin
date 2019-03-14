package com.kevin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot文件上传
 * @createDate 2019/3/13
 */
@RestController     // 该注解表示该类下的方法的返回值会做自动做json格式的转换
public class FileUploadController {

    // 处理文件上传
    @RequestMapping("/fileUploadController")
    public Map<String,Object> fileUpload(MultipartFile fileName) throws IOException {
        System.out.println(fileName.getOriginalFilename());
        fileName.transferTo(new File("E:/"+fileName.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }

}
