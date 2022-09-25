package com.miniprojet.projet.logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class Logs {

    Logger logger = LoggerFactory.getLogger(Logs.class);

    @Around("execution(* com.miniprojet.projet.controllers.*.*(..) )")

    public void beforeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceedingJoinPoint = joinPoint.proceed();
        stopWatch.stop();

        String sigType = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String sigName = joinPoint.getSignature().getName();
        String kind = joinPoint.getKind();
        String target = joinPoint.getTarget().getClass().getSimpleName();

        logger.info(sigType);
        logger.info(sigName);
        logger.info(kind);
        logger.info(target);

    }

}
