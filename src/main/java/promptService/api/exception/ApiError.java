package promptService.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiError {
    private int code;
    private String message;

    public ApiError(int code) {
        this.code = code;
    }

    public ApiError(String message) {
        this.message = message;
    }

    public ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
