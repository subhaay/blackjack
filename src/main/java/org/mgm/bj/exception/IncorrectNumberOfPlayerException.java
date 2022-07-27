package org.mgm.bj.exception;

/**
 * Exception class to represent the Invalid number of players.
 * @author avipokhrel
 */
public class IncorrectNumberOfPlayerException extends Exception {
    public IncorrectNumberOfPlayerException(String errorMessage) {
        super(errorMessage);
    }
}
