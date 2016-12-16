package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	public RateDomainModel rateDM = null;

	public RateDomainModel getRateDM() {
		return rateDM;
	}

	//public void setRateDM(RateDomainModel rateDM) {
		//this.rateDM = rateDM;
	
	public RateException(RateDomainModel RDM){
		rateDM = RDM;
	}
	}
	


//