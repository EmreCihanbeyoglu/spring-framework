package com.cydeo.spring21aop.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspectWithWithin {
    Logger logger = LoggerFactory.getLogger(LoginAspectWithWithin.class);

    @Pointcut("within(com.cydeo.spring21aop.controller..*)")
    private void withinControllerPointcut() {}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceOperation(){}

    @Before("withinControllerPointcut() || anyServiceOperation()")
    public void logBefore_AnyControllerMethodInAnyClassWithinControllerPackage() {
//        logger.info("Before () -> Method: {} - Arguments: {} - Target: {}", joinpoint, joinpoint.get, joinpoint.getTarget());
       logger.info("Entering logBefore_AnyControllerMethodInAnyClassWithinControllerPackage");
    }

}
