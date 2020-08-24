package pl.bykowski.prework;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloApi {

  private final MessageSource messageSource;

  @Value("${default-language}")
  private String defaultLanguage;

  @Autowired
  public HelloApi(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("/hello")
  public String sayHello() {
    return messageSource.getMessage("hello", null, Locale.forLanguageTag(defaultLanguage));
  }
}
