package com.example.starzPlay.paymentGateway.operational;

public abstract class OperationTemplate<AREQ, ARES, IREQ, IRES> {

    protected Validator<AREQ> getValidator() {
        return input -> {
            /*
            No default implementation
            */
        };
    }

    protected abstract Business<IREQ, IRES> getBusiness();

    protected abstract RequestMapper<AREQ, IREQ> getRequestMapper();

    protected abstract ResponseMapper<IRES, ARES> getResponseMapper();

    public ARES execute(AREQ apiRequest) {
        getValidator().validate(apiRequest);
        IREQ internalRequest = getRequestMapper().mapRequest(apiRequest);
        IRES internalResponse = getBusiness().perform(internalRequest);
        return getResponseMapper().mapResponse(internalResponse);
    }
}