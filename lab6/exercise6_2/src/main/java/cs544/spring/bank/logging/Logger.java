package cs544.spring.bank.logging;

import org.apache.log4j.Level;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

public class Logger implements ILogger{

	
	public void log(String logstring) {
		
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
