package com.pudge.elastic.service;

import com.pudge.elastic.mapper.CsGoodsMapper;
import com.pudge.elastic.model.CsGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liuh
 */
@Service("testService")
public class TestService {
    @Autowired
    CsGoodsMapper goodsMapper;
    public void dealBusiness() {
        goodsMapper.insert(new CsGoods());
    }
}
