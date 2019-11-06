package com.pucp.aevent.entity;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.pucp.aevent.entity.ErrorLog;
import com.pucp.aevent.service.impl.ErrorLogService;

@Aspect
public class LoggingAspect {
	@Autowired
    private ErrorLogService errorLogService;
	
    @AfterThrowing(pointcut = "execution(* org.hibernate.*(..))", throwing = "ex")
    public void logErrorDB(Exception ex) {
        ErrorLog log = new ErrorLog("Error al ejecutar un comando SQL!");
        errorLogService.save(log);
    }	
    
    @AfterThrowing(pointcut = "execution(* com.pucp.aevent.entity.*(..))", throwing = "ex")
    public void logErrorJava(Exception ex) {	
        ErrorLog log = new ErrorLog("Error al ejecutar algo de Java!");
        errorLogService.save(log);
    }	
    
    @AfterThrowing(pointcut = "execution(* org.springframework.*(..))", throwing = "ex")
    public void logErrorSpring(Exception ex) {
        ErrorLog log = new ErrorLog("Error al ejecutar algo de Java!");
        errorLogService.save(log);
    }	
      
}
