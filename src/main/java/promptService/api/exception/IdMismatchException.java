package promptService.api.exception;

public class IdMismatchException extends Exception {

    @Override
    public String getMessage() {
        return "ID does not exist or invalid!";
    }

}
