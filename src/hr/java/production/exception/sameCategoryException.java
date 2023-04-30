package hr.java.production.exception;

public class sameCategoryException extends RuntimeException {
    public sameCategoryException(String message) {
        super(message);
    }

    public sameCategoryException(Throwable cause) {
        super(cause);
    }

    public sameCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
