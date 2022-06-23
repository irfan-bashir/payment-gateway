package com.example.starzPlay.paymentGateway.operational;

public interface Business <IREQ, IRES>{
	
	IRES perform(IREQ input);
}
