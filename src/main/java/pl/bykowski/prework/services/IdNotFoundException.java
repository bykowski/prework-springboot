package pl.bykowski.prework.services;

import javax.persistence.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

  public IdNotFoundException(String message) {
    super(message);
  }
}
