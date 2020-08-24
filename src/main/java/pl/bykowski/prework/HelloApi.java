package pl.bykowski.prework;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloApi {

  private final MessageSource messageSource;

  @Autowired
  public HelloApi(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("/hello")
  public String sayHello() {
    return messageSource.getMessage("hello", null, Locale.forLanguageTag("pl"));
  }
}
