package com.pudge.elastic.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liuh
 */
@Configuration
public class MyBatisBatchConfig {
    final
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    public MyBatisBatchConfig(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
