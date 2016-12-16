package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		double rate = 0;
		ArrayList<RateDomainModel> rate1 = new ArrayList<RateDomainModel>(RateDAL.getAllRates());
		for (RateDomainModel rates : rate1){
			if (GivenCreditScore >= rates.getiMinCreditScore());
				rate = rates.getiMinCreditScore();
		}
		if (rate <= 0){	
		}
		return rate;
	}
	
	public static double getPayment(double r, double n, double payments, double f, boolean t) throws RateException
	{		
		double rate = getRate((int)r)/12; 
		double periods = (n * 12);
		double FutureValue = 0; 
		t = false;
	    payments = Math.abs(FinanceLib.pmt(rate, periods, payments, FutureValue, t)); 
		return payments;

	}
}
