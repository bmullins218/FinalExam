package rocketBase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.RateException;

public class Rate_Test {

	

	@Test
	public void testRate() {
		try{
		assertTrue(RateDAL.getAllRates(555)==3.0);
		assertTrue(RateDAL.getAllRates(888)==4.0);
		}
		catch(RateException e){
			System.out.println("Credit Score Too Low");
			
		}
	}

}
