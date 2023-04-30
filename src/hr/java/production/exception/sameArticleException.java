package hr.java.production.exception;

public class sameArticleException extends Exception {
    public sameArticleException(String message) {
        super(message);
    }

    public sameArticleException(Throwable cause) {
        super(cause);
    }

    public sameArticleException(String message, Throwable cause) {
        super(message, cause);
    }
}
