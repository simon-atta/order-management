package com.crossover.salesorder.backend.model.exceptions;

import java.util.Map;

/**
 * Quanity exception represent when products doesn't have enough quanities.
 *
 * @author Simon Ghobreil
 */
public class QuanityException extends Exception {

    private static final long serialVersionUID = 1L;
    private Map<Long, Boolean> results;

    public QuanityException() {
        super();
    }

    /**
     * @param results
     */
    public QuanityException(Map<Long, Boolean> results) {
        super();
        this.results = results;
    }

    /**
     * @return the results
     */
    public Map<Long, Boolean> getResults() {
        return results;
    }

}
