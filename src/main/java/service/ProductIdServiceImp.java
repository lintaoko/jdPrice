package service;

import dao.ProductIdMapper;
import model.ProductId;
import org.springframework.beans.PropertyMatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productIdService")
public class ProductIdServiceImp implements ProductIdService {
    private ProductIdMapper productIdMapper;

    @Autowired
    public void setProductIdMapper(ProductIdMapper productIdMapper) {
        this.productIdMapper = productIdMapper;
    }

    @Override
    public ProductId selectByPrimaryKey(String id) {
        return productIdMapper.selectByPrimaryKey(id);
    }
}
