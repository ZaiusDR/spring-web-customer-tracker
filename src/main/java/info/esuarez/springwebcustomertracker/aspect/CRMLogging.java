package info.esuarez.springwebcustomertracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CRMLogging {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* info.esuarez.springwebcustomertracker.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* info.esuarez.springwebcustomertracker.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* info.esuarez.springwebcustomertracker.repository.*.*(..))")
    private void forRespositoryPackage() {
    }


    @Pointcut("forControllerPackage() || forServicePackage() || forRespositoryPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void beforeLogging(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>>> in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("===>>> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterLogging(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>>> in @AfterReturning: calling method: " + method);

        logger.info("===>>> result: " + result);
    }
}

