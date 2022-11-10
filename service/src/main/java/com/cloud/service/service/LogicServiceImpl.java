package com.cloud.service.service;

import com.cloud.service.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicServiceImpl {

    @Autowired
    FeignInterface feignInterface;

    public String get() {
        return feignInterface.get();
    }
}
