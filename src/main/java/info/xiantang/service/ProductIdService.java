package info.xiantang.service;

import info.xiantang.model.Product;
import org.springframework.cache.annotation.CachePut;

public interface ProductIdService {
//    @CachePut("primaryKey")
    Product selectByPrimaryKey(String id);
}
