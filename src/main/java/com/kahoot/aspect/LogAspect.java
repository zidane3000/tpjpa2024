package com.kahoot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

    @Before("execution( * com.kahoot..*(..))")
    public void logBefore(JoinPoint pjp){
        System.out.println("log ");

        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        System.out.println("Execution of " + className + "." + methodName);
    }

    @AfterReturning("execution(* com.kahoot..*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Méthode exécutée : " + joinPoint.getSignature());
    }
}

