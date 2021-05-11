package com.demos.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-04-09 17:07
 */
@RestController
public class BreakPointFileDownloadController {

    Logger logger = LoggerFactory.getLogger(BreakPointFileDownloadController.class);

    @GetMapping("/download/{name}")
    public void getDownloadFile(@PathVariable(value = "name") String name,
                                HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath() + name;

        File file = new File(path);
        if (!file.exists()){
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

            Enumeration<String> paramName = request.getHeaderNames();
            while (paramName.hasMoreElements()){
                String n = paramName.nextElement().toString();
                if( name.length() > 0){
                    String value = request.getHeader(n);
                    logger.info("************" + n + "：" + value);
                }
            }


        long downloadSize = file.length();
        long fromPos = 0, toPos = 0;
        if (request.getHeader("Range") == null) {
            response.setHeader("Content-Length", downloadSize + "");
            response.setHeader("content-type","text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write("请求不带 Range");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } else {
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            String range = request.getHeader("Range");
            String bytes = range.replaceAll("bytes=", "");
            String[] ary = bytes.split("-");
            fromPos = Long.parseLong(ary[0]);
            if (ary.length == 2) {
                toPos = Long.parseLong(ary[1]);
            }
            int size;
            if (toPos > fromPos) {
                size = (int) (toPos - fromPos);
            } else {
                size = (int) (downloadSize - fromPos);
            }
            response.setHeader("Content-Length", size + "");
            downloadSize = size;

            RandomAccessFile ras = null;
            OutputStream os = null;
            try {
                ras = new RandomAccessFile(file,"rw");
                if (fromPos > 0) {
                    ras.seek(fromPos);
                }
                int bufLen = (int) (downloadSize < 2048 ? downloadSize : 2048);
                byte[] buffer = new byte[bufLen];
                int num;
                int count = 0; // 当前写到客户端的大小
                os = response.getOutputStream();
                while ((num = ras.read(buffer))!= -1){
                    os.write(buffer,0,num);
                    count += num;
                    if (downloadSize - count < bufLen){
                        bufLen = (int) (downloadSize-count);
                        if(bufLen==0){
                            break;
                        }
                        buffer = new byte[bufLen];
                    }
                }
                response.flushBuffer();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if (null != ras){
                    try {
                        ras.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != os){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
