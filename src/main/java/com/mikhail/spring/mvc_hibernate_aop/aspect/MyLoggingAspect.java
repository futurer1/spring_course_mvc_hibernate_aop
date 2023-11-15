package com.mikhail.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Component
@Aspect
public class MyLoggingAspect {

    @Pointcut("execution(* com.mikhail.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl.save*(..))")
    public void saveMethodFromEmployeeDaoImpl() {
    }

    @Pointcut("execution(* com.mikhail.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl.del*(..))")
    private void delMethodFromEmployeeDaoImpl() {
    }

    @Around("saveMethodFromEmployeeDaoImpl() || delMethodFromEmployeeDaoImpl()")
    public Object aroundChangeEmployeeLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {

        System.out.println("Начали выполнять: " + proceedingJoinPoint.getSignature().getName());

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundChangeEmployeeLoggingAdvice: было залогировано исключение " + e);
            throw e;
        }

        System.out.println("Выполнили: " + proceedingJoinPoint.getSignature().getName());

        return targetMethodResult;
    }
}
