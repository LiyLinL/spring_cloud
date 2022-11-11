package com.cloud.service.contorller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class Controller {

    @Autowired
    BeanFactory beanFactory;

    @Value("${server.port}")
    private int port;

    @GetMapping("cloud")
    public String hello() {
        return "Hello Cloud";
    }

    @GetMapping("getPort")
    public int getPort() {
        return port;
    }

    @GetMapping("execute/{serviceName}/{methodName}")
    public String invoke( @PathVariable("serviceName") String serviceName,
                          @PathVariable("methodName") String methodName ) throws Exception {
        Object service = beanFactory.getBean(String.format("%sServiceImpl", StringUtils.uncapitalize(serviceName)));
        Method method = service.getClass().getDeclaredMethod(methodName);

        return (String) method.invoke(service);
    }
}
