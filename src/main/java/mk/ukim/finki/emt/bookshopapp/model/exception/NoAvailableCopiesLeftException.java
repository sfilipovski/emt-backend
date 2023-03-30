package mk.ukim.finki.emt.bookshopapp.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoAvailableCopiesLeftException extends RuntimeException{
    public NoAvailableCopiesLeftException(Long id) {
        super("Book with id:"+id+" has no available copies left");
    }
}
