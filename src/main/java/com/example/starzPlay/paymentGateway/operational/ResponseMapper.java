package com.example.starzPlay.paymentGateway.operational;

public interface ResponseMapper<IRES, ARES> {
	
	ARES mapResponse(IRES response);
}
