package com.pudge.elastic.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Liuh
 * @date 2017/4/24
 */
@Configuration
public class TestJobConfig {

    @Resource
    private ZookeeperRegistryCenter regCenter;

    @Resource
    private ElasticListener elasticListener;

    @Bean
    public TestJob testJob() {
        return new TestJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler testJobScheduler(final TestJob testJob,
                                                        @Value("${testJob.cron}") final String cron,
                                                        @Value("${testJob.shardingTotalCount}") final int shardingTotalCount,
                                                        @Value("${testJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(testJob, regCenter, getLiteJobConfiguration(testJob.getClass(), cron, shardingTotalCount, shardingItemParameters), elasticListener);
    }

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(
                jobClass.getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build(), jobClass.getCanonicalName())).overwrite(true).build();
    }
}
