package db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import db.po.ProductId;
import db.po.ProductIdExample;
import org.apache.ibatis.annotations.Select;

public interface ProductIdMapper {
    long countByExample(ProductIdExample example);

    int deleteByExample(ProductIdExample example);

    int deleteByPrimaryKey(Long productId);

    int insert(ProductId record);

    int insertSelective(ProductId record);

    List<ProductId> selectByExample(ProductIdExample example);

    ProductId selectByPrimaryKey(Long productId);

    int updateByExampleSelective(@Param("record") ProductId record, @Param("example") ProductIdExample example);

    int updateByExample(@Param("record") ProductId record, @Param("example") ProductIdExample example);

    int updateByPrimaryKeySelective(ProductId record);

    int updateByPrimaryKey(ProductId record);



    @Select("SELECT * FROM product_id WHERE product_id = #{product_id}")
    ProductId getProductById(@Param("product_id") String id);

    @Select("SELECT * FROM product_id WHERE assortment = #{assortment} limit 100")
    List<ProductId> getHundredProductByAssortment(@Param("assortment") String assortment);


}