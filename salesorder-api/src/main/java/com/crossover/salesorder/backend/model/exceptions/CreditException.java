package com.crossover.salesorder.backend.model.exceptions;

/**
 * Credit exception represent when customer doesn't have enough balance.
 *
 * @author Simon Ghobreil
 */
public class CreditException extends Exception {

    private String errorCode;

    private static final long serialVersionUID = 1L;

    public CreditException() {
        super();
    }

    /**
     * @param errorCode
     */
    public CreditException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

}
