package cs544.exercise7_1.bank.jms;


public class JMSSender implements IJMSSender{

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
