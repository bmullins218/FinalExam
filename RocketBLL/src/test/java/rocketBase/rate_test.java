package rocketBase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {


	@Test
	public void testRate() {
		try{
		assertTrue(RateBLL.getRate(555) == 4.0);
		assertTrue(RateBLL.getRate(888) == 3.9);
		}
		catch(RateException e){
			System.out.println("Credit Score Too Low");
			
		}
	}
}
