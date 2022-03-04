package people.catalog.exception;

public class NotFoundException extends RuntimeException{
    private static final String message = "User does not exist";
    public NotFoundException() {
        super(message);
    }
}