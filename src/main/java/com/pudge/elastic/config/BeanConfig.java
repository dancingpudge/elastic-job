package com.pudge.elastic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuh
 * @date 2017/11/14
 */
@Configuration
public class BeanConfig {
    private static final Integer TIME_OUT = 20000;

    @Bean(name = "restTemplateForHttp")
    RestTemplate restTemplateForHttp() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        //读取时间10秒
        simpleClientHttpRequestFactory.setReadTimeout(TIME_OUT);
        //连接时间10秒
        simpleClientHttpRequestFactory.setConnectTimeout(TIME_OUT);
        restTemplate.setRequestFactory(simpleClientHttpRequestFactory);
        //添加转换类型
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new FormHttpMessageConverter());
        list.add(new MappingJackson2HttpMessageConverter());
        //http  String 转换
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        list.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(list);
        return restTemplate;
    }


}
