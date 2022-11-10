package com.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "logic")
public interface FeignInterface {

    @GetMapping("get")
    String get();
}
