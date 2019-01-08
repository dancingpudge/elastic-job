package com.pudge.elastic.mapper;

import com.pudge.elastic.model.CsGoods;
import com.pudge.elastic.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Liuh
 */
@Component
@Mapper
public interface CsGoodsMapper extends MyMapper<CsGoods> {
}