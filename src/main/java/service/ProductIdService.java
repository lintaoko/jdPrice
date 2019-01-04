package service;

import model.ProductId;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface ProductIdService {
    @CachePut("primaryKey")
    ProductId selectByPrimaryKey(String id);
}
