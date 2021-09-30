package com.hddz.will.mongodb.interceptor;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Around("execution(public * com.hddz.will.mongodb.controller..*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("args[{}]", Arrays.toString(pjp.getArgs()));
        var attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        var request = Objects.requireNonNull(attributes,"ServletRequestAttributes is null").getRequest();
        var param = request.getParameterMap();
        log.info("param[{}]", map2Str(param));

        return pjp.proceed(pjp.getArgs());
    }

    private String map2Str(Map<?,?> map) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}