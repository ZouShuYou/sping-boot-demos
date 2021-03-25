package com.demos.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 15:07
 */
@RestController
public class FileController {

    @GetMapping("/")
    public String index(){
        return "/upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request){
        if (file.isEmpty()){
            return "upload fail";
        }
        System.out.println(file.getContentType());
        String fileName = file.getOriginalFilename();
        String path = "D:\\tmp\\";
        File fileD = new File(path);
        if (!fileD.exists()){
            fileD.mkdirs();
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(path + fileName));
            fileOutputStream.write(file.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return path + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "upload fail";
    }

    @PostMapping("multiUpload")
    public String multiUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file =  files.get(i);
            if (files.get(i).isEmpty()){
                return "num " + i + " file upload fail";
            }

            System.out.println(file.getContentType());
            String fileName = file.getOriginalFilename();
            String path = "D:\\tmp\\";
            File fileD = new File(path);
            if (!fileD.exists()){
                fileD.mkdirs();
            }
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(new File(path + fileName));
                fileOutputStream.write(file.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "upload success";
    }
}
