package com.rain.dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import com.rain.bean.entity.Commodity;

/**
 * 
 * @Title CommodityDao.java
 * @Description 商品表的基本增删改查
 * @author rain
 * @date 2019年2月14日
 */
public interface CommodityDao extends CrudRepository <Commodity, Serializable> {

}