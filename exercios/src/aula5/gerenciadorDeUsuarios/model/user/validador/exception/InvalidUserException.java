package aula5.strategy.model.user.validador.exception;

public class InvalidUserException extends Exception{

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
