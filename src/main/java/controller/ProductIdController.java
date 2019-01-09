package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ProductIdService;

@RestController
@RequestMapping("/productId")
public class ProductIdController {
    @Autowired
    ProductIdService productIdService;


//    @RequestMapping(method = RequestMethod.GET)
//    public






}
