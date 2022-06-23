package com.example.starzPlay.paymentGateway.operational;

public interface RequestMapper<AREQ, IREQ> {

	IREQ mapRequest(AREQ req);
}
