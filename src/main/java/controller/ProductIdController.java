package controller;

import model.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductIdService;

@RestController
@RequestMapping("/productId")
    public class ProductIdController {
    @Autowired
    ProductIdService productIdService;


    @RequestMapping(method = RequestMethod.GET,
    produces = "application/json")
    public @ResponseBody ProductId productId(
            @RequestParam(value = "id") String id
    ){
        return productIdService.selectByPrimaryKey(id);
    }






}
