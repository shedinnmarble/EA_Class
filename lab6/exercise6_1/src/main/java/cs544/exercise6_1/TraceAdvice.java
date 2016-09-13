package cs544.exercise6_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TraceAdvice {

	public TraceAdvice() {
		// TODO Auto-generated constructor stub
	}

	//@After("execution(* cs544.exercise6_1.EmailSender(..))")
	@After("execution(public * *.sendEmail(String,String))&&args(address,messaage)")
	
	public void  traceaftermethod(JoinPoint joinpoint,String address,String messaage){
	System.out.printf("%s method=%s address=%s message=%s outgoing mail server=%s",
			new Date() ,
			joinpoint.getSignature().getName(),
			address,
			messaage,
			((EmailSender)joinpoint.getTarget()).getOutgoingMailServer()
			);
	}
	@Around("execution(public * CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.printf("Time to execute save = %s\r\n", totaltime);
		// print the time to the console
		return retVal;
		}

}
