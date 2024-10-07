package com.kahoot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Around("execution(public * com.kahoot..*(..))") // Pointcut pour toutes les méthodes publiques
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        // Ici, tu peux ajouter des vérifications de sécurité
        System.out.println("Security check before executing method");

        Object result = joinPoint.proceed(); // Exécute la méthode

        System.out.println("Method executed successfully");
        return result;
    }
}

