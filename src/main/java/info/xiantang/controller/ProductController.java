package info.xiantang.controller;

import info.xiantang.exception.ProductIdNotFoundException;
import info.xiantang.model.Error;
import info.xiantang.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import info.xiantang.service.ProductService;

@RestController
@RequestMapping("/productId")
public class ProductController {
    @Autowired
    ProductService productService;


//    @RequestMapping(method = RequestMethod.GET,
//    produces = "application/json")
//    public @ResponseBody Product productId(
//            @RequestParam(value = "id") String id
//    ){
//        return productService.selectByPrimaryKey(id);
//    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public
//    @ResponseBody
        // 负载部分会渲染在响应体中
    ResponseEntity<Product>
    productIdById(@PathVariable String id) {
        Product product = productService.selectByPrimaryKey(id);
        if (product == null) {
            throw new ProductIdNotFoundException(id);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }





    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<Error> productIdNotFound( 
            ProductIdNotFoundException e
    ) {
        String productId = e.getProductId();
        Error error = new Error(4, "Product [" + productId + "] not found");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }


}
