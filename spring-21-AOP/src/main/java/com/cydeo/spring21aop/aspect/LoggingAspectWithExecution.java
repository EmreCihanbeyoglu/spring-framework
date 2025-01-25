package com.cydeo.spring21aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectWithExecution {


    Logger logger = LoggerFactory.getLogger(LoggingAspectWithExecution.class);


    // a specific class for all its methods
    @Pointcut("execution(* com.cydeo.spring21aop.controller.CourseController.*(..))")
    private void courseController() {}

    @Before("courseController()")
    public void log() {
        logger.info("Logger info from LoggingAspect");
    }



    // a specific method
    @Pointcut("execution(* com.cydeo.spring21aop.repository.CourseRepository.findById(*))")
    private void findByIdMethodFromRepositoryClass() {}


    @Before("findByIdMethodFromRepositoryClass()")
    public void logFor_findByIdMethodFromRepositoryClass() {
        logger.info("this will be logged just before whenever findById runs from repo class");
    }

    // a specific method with arguments
    @Pointcut("execution(* com.cydeo.spring21aop.repository.CourseRepository.findById(*))")
    private void findByIdMethodFromRepositoryClassWithArguments() {}

    @Before("findByIdMethodFromRepositoryClassWithArguments()")
    public void logFor_findByIdMethodFromRepositoryClassWithArguments(JoinPoint joinPoint) {
        logger.info("before (findById) -> method: {} - Arguments: {} - Target: {}", joinPoint.getSignature().getName(), joinPoint.getArgs(), joinPoint.getTarget());
    }

}
