package com.sms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.apache.log4j.Logger;

@Aspect
public class LoggingAspects {
	static Logger log = Logger.getLogger(LoggingAspects.class.getName());
	
	// ADD STUDENT

	@Before("execution(* com.sms.beans.StudentBean_Hibernate.addstudent*(..))")
    public void beforeMethodInvocation(final JoinPoint joinPoint) {
		log.fatal("Adding Student..." + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	@After("execution(* com.sms.beans.StudentBean_Hibernate.addstudent*(..))")
    public void AfterMethodInvocation(final JoinPoint joinPoint) {
		log.fatal("Complete: Add Student" + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	// REMOVE STUDENT
	
	@Before("execution(* com.sms.beans.StudentBean_Hibernate.removestudent*(..))")
    public void beforeMethodRemove(final JoinPoint joinPoint) {
		log.fatal("Removing Student..." + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	@After("execution(* com.sms.beans.StudentBean_Hibernate.removestudent*(..))")
    public void AfterMethodRemove(final JoinPoint joinPoint) {
		log.fatal("Complete: Remove Student" + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	// UPDATE STUDENT

	@Before("execution(* com.sms.beans.StudentBean_Hibernate.updatestudent*(..))")
    public void beforeMethodUpdate(final JoinPoint joinPoint) {
		log.fatal("Updating Student..." + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	@After("execution(* com.sms.beans.StudentBean_Hibernate.updatestudent*(..))")
    public void AfterMethodUpdate(final JoinPoint joinPoint) {
		log.fatal("Complete: Update Student" + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	// LIST STUDENT

	@Before("execution(* com.sms.dao.StudentHibernateDAO.ListStudent*(..))")
    public void beforeMethodList(final JoinPoint joinPoint) {
		log.fatal("Listing Student..." + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }
	
	@After("execution(* com.sms.dao.StudentHibernateDAO.ListStudent*(..))")
    public void AfterMethodList(final JoinPoint joinPoint) {
		log.fatal("Complete: List Student" + joinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + joinPoint.getSignature().getName()
                + " ");
    }

	
	// ADD/REMOVE/UPDATE STUDENT
	
	@Around("myPointCut()")
	public Object aroundMethodInvocation(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.fatal("Completed");
        System.out.println("aroundMethodInvocation");
        System.out.println("Start of " + proceedingJoinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + proceedingJoinPoint.getSignature().getName()
                + " ");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("End of " + proceedingJoinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + proceedingJoinPoint.getSignature().getName()
                + " ");
        return o;
    }
	
	@Pointcut("within(com.sms.beans.*)")
	public void myPointCut() {};
	
}
