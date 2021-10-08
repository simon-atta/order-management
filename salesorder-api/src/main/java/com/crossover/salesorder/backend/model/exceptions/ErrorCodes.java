package com.crossover.salesorder.backend.model.exceptions;

public enum ErrorCodes {

    CODE_EXISTS(202, "code_exists");

    private final int value;

    private final String reasonPhrase;

    private ErrorCodes(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * Return the integer value of this status code.
     */
    public int value() {
        return this.value;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getReasonPhrase() {
        return reasonPhrase;
    }

}
