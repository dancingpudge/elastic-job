package com.pudge.elastic;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.pudge.elastic.service.TestService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 天吴客户社保款预请款总表 （待核销）
 *
 * @author Liuh
 * @date 2017/10/27
 */
@Slf4j
public class TestJob implements SimpleJob {

    @Resource
    TestService testService;

    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                log.info("====--> 开始");
                financeReceiptUnite();
                log.info("====--> 结束");
                break;
            default:

        }
    }

    private void financeReceiptUnite() {
        testService.dealBusiness();
    }
}
