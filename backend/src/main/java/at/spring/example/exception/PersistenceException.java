package at.spring.example.exception;

public class PersistenceException extends RuntimeException {
    public PersistenceException() { super(); }
    public PersistenceException(String message) { super(message); }
    public PersistenceException(Throwable cause) { super(cause); }
    public PersistenceException(String message, Throwable cause) { super(message, cause); }
}
