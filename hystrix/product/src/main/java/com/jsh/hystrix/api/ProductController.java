package com.jsh.hystrix.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @GetMapping(path = "{productId}")
    public String getProductInfo(@PathVariable String productId){
//        throw new RuntimeException("I/O Exception");
        return "[product id = " + productId + " at " + System.currentTimeMillis() + "]";
    }
}
