package kz.petsclinic.clinic.exception;

/**
 * пользовательские ошибки
 */
public class UserException extends Exception{
    public UserException(final String message) {
        super(message);
    }
}
