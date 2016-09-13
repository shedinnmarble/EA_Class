package cs544.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

import cs544.spring.bank.logging.Logger;

@Aspect
public class TraceAdvisor {
	Logger log = new Logger();

	public TraceAdvisor() {
		// TODO Auto-generated constructor stub
	}

	@Before("execution(public * cs544.spring.bank.dao.*.*(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
		log.log("call method=" + joinpoint.getSignature().getName());
	}

	@Around("execution(* cs544.spring.bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {

		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		log.log("Time to execute save = " + totaltime + "\r\n");
		// print the time to the console
		return retVal;
	}

	@After("execution(* cs544.spring.bank.jms.JMSSender.sendJMSMessage(String))&&args(message)")
	public void LogJMS(JoinPoint joinpoint, String message) {
		log.log("JMS = "+message);
	}

}
