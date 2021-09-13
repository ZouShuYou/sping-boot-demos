package com.springboot.demos.converter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-09-13 15:28
 */
public class MyHttpMessageConverter extends AbstractGenericHttpMessageConverter {

    public MyHttpMessageConverter() {
        super(new MediaType("text","properties"));
    }

    @Override
    protected void writeInternal(Object o, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 获取请求头
        HttpHeaders headers = outputMessage.getHeaders();
        // 获取 content-type
        MediaType contentType = headers.getContentType();
        // 获取编码
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }

        charset = charset == null ? Charset.forName("UTF-8") : charset;

        // 获取请求体
        OutputStream body = outputMessage.getBody();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(body, charset);

        Properties properties = (Properties) o;

        properties.store(outputStreamWriter, "Serialized by PropertiesHttpMessageConverter#writeInternal");
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Properties properties = new Properties();
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = null;
        if (contentType != null){
            charset = contentType.getCharset();
        }

        charset = charset == null ? Charset.forName("UTF-8") : charset;

        InputStream body = inputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(body,charset);
        properties.load(inputStreamReader);

        return properties;
    }

    @Override
    public Object read(Type type, Class contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null,inputMessage);
    }

}
