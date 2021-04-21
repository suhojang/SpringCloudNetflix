package com.jsh.hystrix.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductRemoteServiceImpl implements ProductRemoteService{
    private static final String url = "http://product/products/";

    @Autowired
    private RestTemplate restTemplate;
/*
    public ProductRemoteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    @Override
    @HystrixCommand(fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        log.info("getProductInfo productId : " + productId);
        return this.restTemplate.getForObject(url + productId, String.class);
    }

    public String getProductInfoFallback(String productId, Throwable t){
        System.out.println("t = "+t);
        return "[This Product is sold out]";
    }
}
