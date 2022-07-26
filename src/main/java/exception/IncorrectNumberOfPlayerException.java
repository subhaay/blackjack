package exception;

public class IncorrectNumberOfPlayerException extends Exception {
    public IncorrectNumberOfPlayerException(String errorMessage) {
        super(errorMessage);
    }
}
