package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProductIdService;

@Controller
@RequestMapping("/productId")
public class ProductIdController {
    @Autowired
    ProductIdService productIdService;

    


}
