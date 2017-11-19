package com.pudge.elastic.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Liuh
 */
@Data
public class CsGoods {
    private Integer id;

    private Integer customerRouteId;

    private Integer customerId;

    private String goodsName;

    private String goodsDetails;

    private BigDecimal price;

    private String image;

    private Integer num;

    private Integer status;

    private Integer type;

    private BigDecimal discountRate;

    private Integer delFlag;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}