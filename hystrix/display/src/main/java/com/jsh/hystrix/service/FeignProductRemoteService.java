package com.jsh.hystrix.service;

import com.jsh.hystrix.factory.FeignProductRemoteServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FeignClient설정 시 application명으로 접근이 가능하고 FallbackFactory설정으로 circuitBreaker 기능을 사용할 수 있다.
 * application config 파일에 feign.hystrix.enabled=true 설정 필요
 *
 * @FeignClient(name = "[spring.application.name]으로 등록 된 Application명 지정")
 * default 로드밸런싱(Eureka의 Ribbon)
 * 직접 url지정을 원할 경우는 @FeignClient(name = "product", url= "지정 url")형태로 사용
 * 다른 Application과 통신을 할 때 유용
 */
@FeignClient(name = "product", fallbackFactory = FeignProductRemoteServiceFallbackFactory.class)
public interface FeignProductRemoteService {
    @RequestMapping("/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}
