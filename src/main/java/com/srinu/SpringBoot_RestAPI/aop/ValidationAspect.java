package com.srinu.SpringBoot_RestAPI.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.srinu.SpringBoot_RestAPI.service.JobService.getJob(..)) && args(postId)")
    public Object validationUserInput(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("user enter negative value,updating it!");
            postId=-postId;
            LOGGER.info("Update Post ID "+postId);
        }
        Object obj=jp.proceed(new Object[]{postId});
        return obj;

    }
}
