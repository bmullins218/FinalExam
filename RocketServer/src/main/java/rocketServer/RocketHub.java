package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			 double payments = 0;
			 double loanRate = 0;
			 try{
				 payments = RateBLL.getPayment(lq.getiCreditScore(), lq.getiTerm(), lq.getdAmount(), 0, false);
				 loanRate = RateBLL.getRate(lq.getiCreditScore());
			 }
			 catch (RateException e){
			 }
			 lq.setdPayment(payments);
			 lq.setdRate(loanRate);	
			sendToAll(lq);
		}
	}
}
