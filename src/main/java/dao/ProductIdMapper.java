package dao;

import model.ProductId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ProductIdMapper {

    @Select("SELECT * FROM product_id where product_id =  #{id}")
    @Results(value = {
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "assortment",property = "assortment"),
            @Result(column = "img_url", property = "imgUrl"),
            @Result(column = "product_id",property = "productId"),
            @Result(column = "product_type",property = "productType")
    })
    ProductId selectByPrimaryKey(@Param("id") String id);

}