package com.pudge.elastic.config;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.springframework.stereotype.Service;

/**
 * @author Liuh
 * @date 2017/11/14
 */
@Service("testElasticListener")
public class ElasticListener implements ElasticJobListener {

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {

    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {

    }
}
