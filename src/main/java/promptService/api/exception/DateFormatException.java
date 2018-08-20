package promptService.api.exception;

public class DateFormatException extends Exception {

    @Override
    public String getMessage() {
        return "Unparseable date parameter! Proper date format: YYYY-MM-DD.";
    }

    @Override
    public String getLocalizedMessage() {
        return "Unparseable date parameter! Proper date format: YYYY-MM-DD.";
    }
}
