package controller;

import exception.ProductIdNotFoundException;
import model.Error;
import model.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductIdService;

import java.nio.file.ProviderNotFoundException;

@RestController
@RequestMapping("/productId")
public class ProductIdController {
    @Autowired
    ProductIdService productIdService;


//    @RequestMapping(method = RequestMethod.GET,
//    produces = "application/json")
//    public @ResponseBody ProductId productId(
//            @RequestParam(value = "id") String id
//    ){
//        return productIdService.selectByPrimaryKey(id);
//    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public
//    @ResponseBody
        // 负载部分会渲染在响应体中
    ResponseEntity<ProductId>
    productIdById(@PathVariable String id) {
        ProductId productId = productIdService.selectByPrimaryKey(id);
        if (productId == null) {
            throw new ProductIdNotFoundException(id);
        }
        return new ResponseEntity<ProductId>(productId, HttpStatus.OK);
    }


    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<Error> productIdNotFound( 
            ProductIdNotFoundException e
    ) {
        String productId = e.getProductId();
        Error error = new Error(4, "ProductId [" + productId + "] not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }


}
