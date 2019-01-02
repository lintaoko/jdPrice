package service;

import model.ProductId;

public interface ProductIdService {
    ProductId selectByPrimaryKey(String id);
}
