package com.pudge.elastic;


import com.pudge.elastic.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Liuh
 * @date 2017/3/14
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.pudge.elastic.mapper", markerInterface = MyMapper.class)
public class SpringBootMain {

    public static void main(final String[] args) {

        SpringApplication.run(SpringBootMain.class, args);
    }
}