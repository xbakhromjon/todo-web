package uz.bakhromjon.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

/**
 * @author Bakhromjon Sat, 8:29 PM 2/19/2022
 */
@Setter
@Getter
public class UserNotFoundException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public UserNotFoundException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public UserNotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
