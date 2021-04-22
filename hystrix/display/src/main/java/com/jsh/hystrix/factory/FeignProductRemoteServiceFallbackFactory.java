package com.jsh.hystrix.factory;

import com.jsh.hystrix.service.FeignProductRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignProductRemoteServiceFallbackFactory implements FallbackFactory<FeignProductRemoteService> {
    @Override
    public FeignProductRemoteService create(Throwable cause) {
        System.out.println("t = " + cause);
        return productId -> "[This Product is sold out]";
    }
}
