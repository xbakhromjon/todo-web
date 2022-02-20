package uz.bakhromjon.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Bakhromjon Sat, 8:29 PM 2/19/2022
 */
@Setter
@Getter
public class NotFoundException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public NotFoundException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public NotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
