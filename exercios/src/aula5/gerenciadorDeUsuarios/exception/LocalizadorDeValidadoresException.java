package aula5.strategy.exception;

public class LocalizadorDeValidadoresException extends RuntimeException {


    public LocalizadorDeValidadoresException(String message) {
        super(message);
    }

    public LocalizadorDeValidadoresException(String message, Throwable cause) {
        super(message, cause);
    }
}
