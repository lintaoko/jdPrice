package info.xiantang.service;

import info.xiantang.model.Product;
import org.springframework.cache.annotation.CachePut;

public interface ProductService {
//    @CachePut("primaryKey")
    Product selectByPrimaryKey(String id);
}
