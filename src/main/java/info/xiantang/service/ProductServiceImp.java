package info.xiantang.service;

import info.xiantang.dao.ProductIdMapper;
import info.xiantang.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productIdService")
public class ProductServiceImp implements ProductService {
    private ProductIdMapper productIdMapper;

    @Autowired
    public void setProductIdMapper(ProductIdMapper productIdMapper) {
        this.productIdMapper = productIdMapper;
    }


    @Override
    public Product selectByPrimaryKey(String id) {
        return productIdMapper.selectByPrimaryKey(id);
    }
}
