package model.dao.exception;

public class DAOException extends Exception{
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DAOException(String message) {
        super(message);
    }
}
